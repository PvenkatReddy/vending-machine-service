package com.learning.vending.resource.server.common;

public class StringUtils {

	public static boolean isBlankOrNull(String str) {
		if(str == null || str.isBlank() || str.isEmpty()) {
			return true;
		} 
		return false;
	}
}
