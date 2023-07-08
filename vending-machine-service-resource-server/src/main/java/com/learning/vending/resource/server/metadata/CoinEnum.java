package com.learning.vending.resource.server.metadata;

import lombok.Getter;

public enum CoinEnum {

	FIEFTYCOIN(50), TWENTYCOIN(20), TENCOIN(10), FIVECOIN(5), TWOCOIN(2), ONECOIN(1);
	
	@Getter int price;
	
	CoinEnum(int price) {
		this.price = price;
	}
	
	public static int getCoinCount(int amount, CoinEnum coin) {
		int count = 0;
		switch(coin) {
			case FIEFTYCOIN :
				count = amount >= FIEFTYCOIN.getPrice()? amount/coin.getPrice(): 0;
				break;
			case TWENTYCOIN:	
				count = amount >= TWENTYCOIN.getPrice()? amount/coin.getPrice(): 0;
				break;
			case TENCOIN:
				count = amount >= TENCOIN.getPrice()? amount/coin.getPrice(): 0;
				break;
			case FIVECOIN:
				count =  amount >= FIVECOIN.getPrice()? amount/coin.getPrice(): 0;
				break;
			case TWOCOIN:
				count =  amount >= TWOCOIN.getPrice()? amount/coin.getPrice(): 0;
				break;
			case ONECOIN:
				count =  amount >= ONECOIN.getPrice()? amount/coin.getPrice(): 0;
				break;
		}
		return count;
	}
}
