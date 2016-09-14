package com.amor.web.security;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import com.amor.orm.model.AAuthority;
import com.amor.orm.model.APrivilege;
import com.amor.orm.model.ARole;
import com.amor.service.AuthorityService;
import com.amor.service.PrivilegeService;
import com.amor.service.RoleService;

@Component(value = "securityRealm")
public class SecurityRealm extends AuthorizingRealm {

	@Resource
	private AuthorityService authorityService;

	@Resource
	private RoleService roleService;

	@Resource
	private PrivilegeService privilegeService;
	

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		String username = String.valueOf(principals.getPrimaryPrincipal());

		final AAuthority auth = authorityService.selectByName(username);
		final List<ARole> roleList = roleService.selectByParentId(auth.getId());
		for (ARole role : roleList) {
			authorizationInfo.addRole(role.getType());
			
			final List<APrivilege> privilegeList = privilegeService.selectByParentId(role.getId());
			for(APrivilege privilege : privilegeList){
				authorizationInfo.addStringPermission(privilege.getOperationCode());
			}
		}
		return authorizationInfo;
	}

	/**
	 * 验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = String.valueOf(token.getPrincipal());
		String password = new String((char[]) token.getCredentials());
		AAuthority auth = authorityService.authentication(username, password);
		if (auth == null)
			throw new AuthenticationException("登录失败，用户名或密码错误。");
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, password, getName());
		return authenticationInfo;
	}

}
