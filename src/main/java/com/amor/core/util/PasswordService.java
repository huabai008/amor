package com.amor.core.util;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * 密碼加密服务，采用PBE算法，生成64/70位密码
 * 
 * @author huaba
 *
 */

public interface PasswordService {

	String createHash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException;
	
	String createHash(char[] password) throws NoSuchAlgorithmException, InvalidKeySpecException;
	
	boolean validatePassword(String password, String correctHash) throws NoSuchAlgorithmException, InvalidKeySpecException;
	
	boolean validatePassword(char[] password, String correctHash) throws NoSuchAlgorithmException, InvalidKeySpecException;
}
