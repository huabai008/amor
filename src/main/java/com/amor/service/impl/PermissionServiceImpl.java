package com.amor.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.amor.core.base.BaseMapper;
import com.amor.core.base.BaseServiceImpl;
import com.amor.orm.mapper.APermissionMapper;
import com.amor.orm.model.APermission;
import com.amor.service.PermissionService;

@Service
public class PermissionServiceImpl extends BaseServiceImpl<APermission, Integer> implements PermissionService{

	@Resource
	private APermissionMapper permissionMapper;
	
	@Override
	public BaseMapper<APermission, Integer> getMapper() {
		return permissionMapper;
	}

	
}
