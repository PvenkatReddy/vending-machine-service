package com.learning.vending.metadata;

import lombok.Getter;

public enum Coin {

	ONECOIN(1), FIRVECOIN(5), TENCOIN(10), TWENTYCOIN(20);
	
	@Getter int price;
	
	Coin(int price) {
		this.price = price;
	}
	
	
}
