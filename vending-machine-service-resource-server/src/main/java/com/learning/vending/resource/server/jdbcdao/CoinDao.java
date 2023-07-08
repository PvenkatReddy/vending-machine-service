package com.learning.vending.resource.server.jdbcdao;

import java.util.List;
import java.util.Map;

import com.learning.vending.resource.server.metadata.CoinEnum;
import com.learning.vending.resource.server.model.Coin;

public interface CoinDao {

	public Coin getCoin(CoinEnum coin, boolean forUpdate);
	
	public int updateCoin(Coin coin);
	
	public Map<CoinEnum, Coin> getCoins();
	
	public int[] updateCoins(List<Coin> coins);
	
}
