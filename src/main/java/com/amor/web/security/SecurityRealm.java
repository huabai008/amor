package com.amor.web.security;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

import com.amor.core.util.Constants;
import com.amor.orm.model.AUser;
import com.amor.service.UserService;

@Component(value = "securityRealm")
public class SecurityRealm extends AuthorizingRealm {

	@Resource	
	private UserService userService;
	
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		String username = String.valueOf(principals.getPrimaryPrincipal());

		return authorizationInfo;
	}

	/**
	 * 验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordWithCaptchaToken tokenWithCap = (UsernamePasswordWithCaptchaToken) token;
		Session session = getSession();
		//验证码验证
		
		//用户名密码验证
		AUser user = userService.selectByName(tokenWithCap.getUsername());
		if (user == null)
			throw new UnknownAccountException("登录失败，用户名/密码错误。");
		
		//账户登录权限验证
		if(user.getStatus() <= 0)
			throw new LockedAccountException("登录失败，用户被禁止登录。");
		
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
		
		//将用户基础信息写入Session
		session.setAttribute(Constants.USER_INFO, user.getId());
		
		return authenticationInfo;
	}
	
	private Session getSession(){
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession(false);
		if(session == null){
			session = subject.getSession();
		}		
		return session;
	}

}
