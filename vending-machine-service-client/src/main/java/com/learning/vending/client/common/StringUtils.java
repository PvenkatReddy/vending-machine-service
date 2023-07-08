package com.learning.vending.client.common;

public class StringUtils {

	public static boolean isBlankOrNull(String str) {
		if(str == null || str.isBlank() || str.isEmpty()) {
			return true;
		} 
		return false;
	}
}
