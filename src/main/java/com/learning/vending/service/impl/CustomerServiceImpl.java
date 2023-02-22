package com.learning.vending.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.learning.vending.exception.VendingMachineUserDataException;
import com.learning.vending.form.UserTransactionForm;
import com.learning.vending.jdbcdao.CoinDao;
import com.learning.vending.jdbcdao.ProductDao;
import com.learning.vending.jdbcdao.UserTransactionDao;
import com.learning.vending.model.Bucket;
import com.learning.vending.model.Coin;
import com.learning.vending.model.Product;
import com.learning.vending.model.UserTransaction;
import com.learning.vending.service.CustomerService;
import com.learning.vending.metadata.*;

public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	UserTransactionDao transactionDao;

	@Autowired
	CoinDao coinDao;
	
	@Override
	@Transactional
	public List<Product> getProducts() {
		return productDao.getProducts();
	}

	@Override
	@Transactional
	public Bucket<Product, List<Coin>> dispatch(UserTransactionForm userTransactionForm) {
		
		Bucket<Product, List<Coin>> bucket = new Bucket<Product, List<Coin>>();
		List<Coin> updatedCoinList = new ArrayList<>();
		List<Coin> coinList = new ArrayList<>();
		UserTransaction userTransaction =  userTransactionForm.initUserTransaction();
		Product product =  productDao.getProduct(userTransactionForm.getProductId(), false);
		int totalAmount = product.getPrice() * userTransactionForm.getQuantity();
		if(product.getCount() < userTransactionForm.getQuantity()) {
			throw new VendingMachineUserDataException("User selected Product quantity is not avaialble "+userTransactionForm.getQuantity());
		}
		
		//transactionDao.createTransaction(userTransaction);
		int difference = userTransactionForm.getCoin().getPrice() - totalAmount;
		
		if(difference > 0) {
			userTransaction.setReturnAmount(difference);
//			int coinCount = 0;
//			coinCount = CoinEnum.getCoinCount(difference, CoinEnum.FIEFTYCOIN);
//			coinCount = updateCoinCount(coinCount, CoinEnum.FIEFTYCOIN);
//			remainingAmount(coinCount, );
//			if(difference >0 ) {
//				coinCount = CoinEnum.getCoinCount(difference, CoinEnum.TWENTYCOIN);
//				difference = updateCoinCount(coinCount, CoinEnum.TWENTYCOIN);
//				if(difference >0 ) {
//					
//				}
//			}
			Map<CoinEnum, Coin> coinMap =  coinDao.getCoins();
			if(coinMap.isEmpty()) {
				throw new VendingMachineUserDataException("Enough change is not available");
			}
			CoinEnum[] coinEnums = CoinEnum.values();
			for(CoinEnum coinEnum: coinEnums) {
				if(difference >= coinEnum.getPrice()) {
					int coinCount = CoinEnum.getCoinCount(difference, coinEnum);
					Coin dbCoin = coinMap.get(coinEnum);
					if(coinCount > 0 && dbCoin != null) {
						Coin updateCoin = new Coin();
						updateCoin.setId(dbCoin.getId());
						updateCoin.setName(dbCoin.getName());
						if(dbCoin.getCount() < coinCount) {
							difference = difference - dbCoin.getCount()*coinEnum.getPrice();
							updateCoin.setCount(0);
						} else {
							difference = difference - coinCount*coinEnum.getPrice();
							updateCoin.setCount(dbCoin.getCount()-coinCount);
							dbCoin.setCount(coinCount);
						}
						coinList.add(dbCoin);
						updatedCoinList.add(updateCoin);
					}
				} else if(userTransactionForm.getCoin().getPrice() == coinEnum.getPrice()){
					Coin updateCoin = coinMap.get(coinEnum);
					updateCoin.setCount(updateCoin.getCount()+1);
					updatedCoinList.add(updateCoin);
				}
			}
			if(difference > 0) {
				throw new VendingMachineUserDataException("Enough change is not available");
			} else {
				coinDao.updateCoins(updatedCoinList);
			}
		} else if(difference == 0) {
			int productCount = product.getCount();
			product.setCount(productCount - userTransactionForm.getQuantity());
			productDao.updateProduct(product);
			userTransaction.setReturnAmount(0);
			userTransaction.setUserId("1");
		} else {
			throw new VendingMachineUserDataException("User amount is less than total amount");
		}
		userTransaction.setUserId("6");
		transactionDao.createTransaction(userTransaction);
		product.setCount(product.getCount() - userTransactionForm.getQuantity());
		productDao.updateProduct(product);
		Product updateProduct = new Product();
		updateProduct.setId(product.getId());
		updateProduct.setName(product.getName());
		updateProduct.setCount(userTransactionForm.getQuantity());
		return bucket.of(updateProduct, coinList);
	}
	
//	public int updateCoinCount(int coinCount, CoinEnum coinEnum) {
//		if(coinCount > 0) {
//			Coin coin = coinDao.getCoin(coinEnum, false);
//			if(coin.getCount()>=coinCount) {
//				int dbCount = coin.getCount();
//				coin.setCount(dbCount - coinCount);
//				coinDao.updateCoin(coin);
//			} else {
//				coin.setCount(0);
//				coinDao.updateCoin(coin);
//				return coinCount-coin.getCount();
//			}
//		}
//		return 0;
//	}

	public int remainingAmount(int coinCount, int difference, CoinEnum coinEnum) {
		int amount = 0;
		if(coinCount >0) {
			amount = coinCount*coinEnum.getPrice();
		}
		amount += difference;
		return amount;
	}
}
