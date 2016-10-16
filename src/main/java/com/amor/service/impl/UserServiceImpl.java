package com.amor.service.impl;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.stereotype.Service;

import com.amor.core.base.BaseMapper;
import com.amor.core.base.BaseServiceImpl;
import com.amor.core.util.PasswordService;
import com.amor.orm.mapper.APermissionMapper;
import com.amor.orm.mapper.ARoleMapper;
import com.amor.orm.mapper.ARoleWebPermissionMapper;
import com.amor.orm.mapper.AUserMapper;
import com.amor.orm.mapper.AUserRoleMapper;
import com.amor.orm.mapper.AWebInfoMapper;
import com.amor.orm.model.APermission;
import com.amor.orm.model.ARole;
import com.amor.orm.model.AUser;
import com.amor.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<AUser, Integer> implements UserService{

	@Resource
	private AUserMapper userMapper;
	
	@Override
	public int insert(AUser model) {
		return userMapper.insert(model);
	}

	@Override
	public int update(AUser model) {
		return userMapper.updateByPrimaryKey(model);
	}

	@Override
	public int delete(Integer id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public AUser selectById(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public BaseMapper<AUser, Integer> getMapper() {
		return userMapper;
	}
	
	@Override
	public AUser authentication(AUser user){
		AUser user_0 = selectByName(user.getUsername());
		return null;
	}

	@Override
	public AUser selectByName(String username) {
		return userMapper.selectByName(username);
	}
}
