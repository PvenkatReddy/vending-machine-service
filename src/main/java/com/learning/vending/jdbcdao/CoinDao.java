package com.learning.vending.jdbcdao;

import java.util.List;
import java.util.Map;

import com.learning.vending.metadata.CoinEnum;
import com.learning.vending.model.Coin;

public interface CoinDao {

	public Coin getCoin(CoinEnum coin, boolean forUpdate);
	
	public int updateCoin(Coin coin);
	
	public Map<CoinEnum, Coin> getCoins();
	
	public int[] updateCoins(List<Coin> coins);
	
}
