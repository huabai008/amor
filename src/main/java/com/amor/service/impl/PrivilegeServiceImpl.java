package com.amor.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.amor.orm.mapper.APrivilegeMapper;
import com.amor.orm.model.APrivilege;
import com.amor.service.PrivilegeService;

@Service
public class PrivilegeServiceImpl implements PrivilegeService{

	@Resource
	private APrivilegeMapper privilegeMapper;
	
	@Override
	public List<APrivilege> selectByParentId(int id) {
		return privilegeMapper.selectByParentId(id);
	}

}
