package com.amor.service;

import com.amor.core.generic.GenericService;
import com.amor.orm.model.AUser;

public interface UserService extends GenericService<AUser, Integer>{
	
	AUser authentication(AUser user);
	
	AUser selectByName(String username);
}
