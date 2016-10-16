package com.amor.service;

import java.util.Set;

import com.amor.core.base.BaseService;
import com.amor.orm.model.ARole;

public interface RoleService extends BaseService<ARole, Integer>{
	void selectRolePermission(ARole role);

	Set<Integer> selectPermissionIdByRoleId(Integer role_id);
}
