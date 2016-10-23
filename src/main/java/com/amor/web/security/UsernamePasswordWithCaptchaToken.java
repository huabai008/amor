package com.amor.web.security;

import org.apache.shiro.authc.UsernamePasswordToken;

public class UsernamePasswordWithCaptchaToken extends UsernamePasswordToken{
	private String captcha;
	
	public UsernamePasswordWithCaptchaToken(){
		super();
	}
	
	public UsernamePasswordWithCaptchaToken(String username, String password, String captcha){
		super(username, password);
		this.captcha = captcha;
	}
	
	public UsernamePasswordWithCaptchaToken(String username, String password, boolean rememberMe, String host, String captcha){
		this(username, password.toCharArray(), rememberMe, host, captcha);
	}
	
	public UsernamePasswordWithCaptchaToken(String username, char[] password, boolean rememberMe, String host, String captcha){
		super(username, password, rememberMe, host);
		this.captcha = captcha;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	
}
