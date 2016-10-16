package com.amor.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.amor.core.base.BaseMapper;
import com.amor.core.base.BaseServiceImpl;
import com.amor.orm.mapper.AUserMapper;
import com.amor.orm.mapper.AUserRoleMapper;
import com.amor.orm.model.ARolePermission;
import com.amor.orm.model.AUser;
import com.amor.orm.model.AUserRole;
import com.amor.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<AUser, Integer> implements UserService {

	@Resource
	private AUserMapper userMapper;

	@Resource
	private AUserRoleMapper userRoleMapper;

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
	public AUser selectByName(String username) {
		return userMapper.selectByName(username);
	}

	@Override
	public void selectUserRole(AUser user) {
		List<AUserRole> roleList = userRoleMapper.selectByUserId(user.getId());
		for (AUserRole role : roleList) {
			user.addRole(role.getRoleId());
		}
	}

	@Override
	public Set<Integer> selectRoleIdByUserId(Integer user_id) {
		Set<Integer> result = new HashSet<>();
		List<AUserRole> roleList = userRoleMapper.selectByUserId(user_id);
		for (AUserRole role : roleList) {
			result.add(role.getRoleId());
		}
		return result;
	}
}
