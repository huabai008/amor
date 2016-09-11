package com.amor.web.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

@Component(value="securityRealm")
public class SeurityRealm extends AuthorizingRealm{

	/**
	 * 验证权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		
		return authorizationInfo;
	}

	/**
	 * 验证登录
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		// TODO Auto-generated method stub
		String username = String.valueOf(arg0.getPrincipal());
		String password = new String((char[]) arg0.getCredentials());
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, password, getName());
		return authenticationInfo;
	}

}
