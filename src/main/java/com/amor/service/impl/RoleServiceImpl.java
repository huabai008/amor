package com.amor.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.amor.orm.mapper.ARoleMapper;
import com.amor.orm.model.ARole;
import com.amor.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Resource
	private ARoleMapper roleMapper;
	
	@Override
	public List<ARole> selectByParentId(int id) {
		return roleMapper.selectByParentId(id);
	}

}
