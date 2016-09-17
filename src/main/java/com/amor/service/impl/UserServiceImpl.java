package com.amor.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.amor.core.generic.GenericMapper;
import com.amor.core.generic.GenericServiceImpl;
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
public class UserServiceImpl extends GenericServiceImpl<AUser, Integer> implements UserService{

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
	public GenericMapper<AUser, Integer> getMapper() {
		return userMapper;
	}
	
	@Override
	public AUser authentication(AUser user){
		return userMapper.authentication(user);
	}

	@Override
	public AUser selectByName(String username) {
		return userMapper.selectByName(username);
	}
}
