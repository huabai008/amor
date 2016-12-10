package com.amor.core.util;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.stereotype.Service;

@Service
public class PasswordServiceImpl implements PasswordService{

	private final String PBKDF2_ALGORITHM = "PBKDF2WithHmacSHA1";
	
	private final String SEPARATOR = ":";
	
	private final int SALT_BYTE_SIZE = 16;
	private final int HASH_BYTE_SIZE = 16;
	private final int PBKDF2_ITERATIONS = 1000;
	
	private final int ITERATION_INDEX = 0;
	private final int SALT_INDEX = 1;
	private final int PBKDF2_INDEX = 2;
	
	@Override
	public String createHash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
		return createHash(password.toCharArray());
	}

	/**
	 * 加密
	 * @throws InvalidKeySpecException 
	 * @throws NoSuchAlgorithmException 
	 */
	@Override
	public String createHash(char[] password) throws NoSuchAlgorithmException, InvalidKeySpecException {
		byte[] salt = initSalt();
		byte[] hash = pbkdf2(password, salt, PBKDF2_ITERATIONS, HASH_BYTE_SIZE);
		return PBKDF2_ITERATIONS + SEPARATOR + toHex(salt) + SEPARATOR + toHex(hash);
	}

	@Override
	public boolean validatePassword(String password, String correctHash) throws NoSuchAlgorithmException, InvalidKeySpecException {
		return validatePassword(password.toCharArray(), correctHash);
	}

	/**
	 * 验证
	 * @throws InvalidKeySpecException 
	 * @throws NoSuchAlgorithmException 
	 */
	@Override
	public boolean validatePassword(char[] password, String correctHash) throws NoSuchAlgorithmException, InvalidKeySpecException {
		String[] correct = correctHash.split(SEPARATOR);
		int iterations = Integer.parseInt(correct[ITERATION_INDEX]);
		byte[] salt = fromHex(correct[SALT_INDEX]);
		byte[] hash = fromHex(correct[PBKDF2_INDEX]);
		
		//使用相同salt获取password的hash
		byte[] test = pbkdf2(password, salt, iterations, hash.length);
		return slowEquals(hash, test);
	}
	
	/**
	 * 初始化salt
	 * @return
	 */
	private byte[] initSalt(){
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[SALT_BYTE_SIZE];
		random.nextBytes(salt);
		return salt;
	}
	
	/**
	 * 生成pbkdf2码
	 * @param password
	 * @param salt
	 * @param iterations
	 * @param bytes
	 * @return
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeySpecException 
	 */
	private byte[] pbkdf2(char[] password, byte[] salt, int iterations, int bytes) throws NoSuchAlgorithmException, InvalidKeySpecException{
		PBEKeySpec keySpec = new PBEKeySpec(password, salt, iterations, bytes*8);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(PBKDF2_ALGORITHM);
		return keyFactory.generateSecret(keySpec).getEncoded();
	}
	
	private boolean slowEquals(byte[] a, byte[] b){
		int diff = a.length ^ b.length;
		for(int i = 0; i < a.length && i < b.length; i++){
			diff |= a[i] ^ b[i];
		}
		return diff == 0;
	}

	/**
	 * 转为16进制，不足位补0
	 * @param array
	 * @return
	 */
	private String toHex(byte[] array){
		BigInteger bi = new BigInteger(1, array);
		String hex = bi.toString(16);
		int paddingLength = array.length * 2 - hex.length();
		if(paddingLength > 0){
			return String.format("%0" + paddingLength + "d", 0) + hex;
		}else{
			return hex;
		}
	}
	
	/**
	 * 解析16进制
	 * @param hex
	 * @return
	 */
	private byte[] fromHex(String hex){
		byte[] array = new byte[hex.length()/2];
		for(int i = 0; i < array.length; i++){
			array[i] = (byte) Integer.parseInt(hex.substring(2*i, 2*i+2), 16);
		}
		return array;
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException{
		PasswordService s = new PasswordServiceImpl();
		System.out.println(s.createHash("zhangyue"));
	}
}