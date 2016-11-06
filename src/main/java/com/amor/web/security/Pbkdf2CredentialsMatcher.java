package com.amor.web.security;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

import com.amor.core.util.PasswordService;

import net.sf.ehcache.Element;

public class Pbkdf2CredentialsMatcher extends SimpleCredentialsMatcher{
	
	private final int MAX_RETRY_TIMES = 5;
	
	@Resource 
	private PasswordService passwordService;
	
	private Cache<String, Element> cache;
	
	public Pbkdf2CredentialsMatcher(CacheManager cacheManager) {
		cache = cacheManager.getCache("passwordRetryCache");
	}
	
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info){
		String username = String.valueOf(token.getPrincipal());
		Element element = cache.get(username);
		if(element == null){
			element = new Element(username, new AtomicInteger(0));
			cache.put(username, element);
		}
		AtomicInteger retryCount = (AtomicInteger) element.getObjectValue();
		if(retryCount.incrementAndGet() > MAX_RETRY_TIMES)
			throw new ExcessiveAttemptsException("登录次数过多，请稍后再试。");
		
		boolean match = false;
		try {
			match = passwordService.validatePassword((char[]) token.getCredentials(), String.valueOf(info.getCredentials()));
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return match;
	}
}
