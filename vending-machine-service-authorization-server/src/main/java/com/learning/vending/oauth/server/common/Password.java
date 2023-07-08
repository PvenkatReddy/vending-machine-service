package com.learning.vending.oauth.server.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.learning.vending.oauth.server.exception.VendingAuthenticationException;
import com.learning.vending.oauth.server.model.User;

public class Password {

	public static String getHashedPassword(User user, String cleartext) {
		return getHashed(cleartext);
	}
	
	private static String getHashed(String cleartext) {
		StringBuilder hexString = new StringBuilder();
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(cleartext.getBytes());
			byte[] hash = md.digest();
	
			for (int i = 0; i < hash.length; i++) {
				if ((0xff & hash[i]) < 0x10) {
					hexString.append("0"
							+ Integer.toHexString((0xFF & hash[i])));
				} else {
					hexString.append(Integer.toHexString(0xFF & hash[i]));
				}
			}
		} catch (NoSuchAlgorithmException e) {
			throw new VendingAuthenticationException("" + e);
		}
		return hexString.toString();
	}
	
	public static boolean match(User user, String password) {
		if(getHashed(password).equals(user.getPassword()))
			return true;
		else 
			return false;
	}
	 
}
