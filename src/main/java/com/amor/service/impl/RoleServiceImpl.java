package com.amor.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.amor.core.base.BaseMapper;
import com.amor.core.base.BaseServiceImpl;
import com.amor.orm.mapper.ARoleMapper;
import com.amor.orm.mapper.ARolePermissionMapper;
import com.amor.orm.model.ARole;
import com.amor.orm.model.ARolePermission;
import com.amor.service.RoleService;

@Service
public class RoleServiceImpl extends BaseServiceImpl<ARole, Integer> implements RoleService{

	@Resource
	private ARoleMapper roleMapper;
	
	@Resource
	private ARolePermissionMapper rolePermissionMapper;
	
	@Override
	public BaseMapper<ARole, Integer> getMapper() {
		return roleMapper;
	}

	@Override
	public void selectRolePermission(ARole role) {
		List<ARolePermission> permissionList = rolePermissionMapper.selectByRoleId(role.getId());
		for(ARolePermission permission:permissionList){
			role.addPermission(permission.getPermissionId());
		}
	}

	@Override
	public Set<Integer> selectPermissionIdByRoleId(Integer role_id) {
		Set<Integer> result = new HashSet<>();
		List<ARolePermission> permissionList = rolePermissionMapper.selectByRoleId(role_id);
		for(ARolePermission permission:permissionList){
			result.add(permission.getPermissionId());
		}
		return result;
	}

	@Override
	public int addRolePermission(ARole role, Integer permission_id){
		return addRolePermission(role.getId(), permission_id);
	}
	
	@Override
	public int addRolePermission(Integer role_id, Integer permission_id){
		ARolePermission permission = new ARolePermission();
		permission.setRoleId(role_id);
		permission.setPermissionId(permission_id);
		return rolePermissionMapper.insert(permission);
	}

	@Override
	public int deleteRolePermission(ARole role, Integer permission_id) {
		// TODO Auto-generated method stub
		return 0;
	}
}
