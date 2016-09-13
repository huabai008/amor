package com.amor.orm.service.impl;

import org.springframework.stereotype.Service;

import com.amor.orm.mapper.AAuthorityMapper;
import com.amor.orm.model.ALogin;
import com.amor.orm.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	private AAuthorityMapper loginMapper;
	
	public ALogin getALogin(int id) {
		// TODO Auto-generated method stub
		return loginMapper.selectByPrimaryKey(id);
	}
	
	public ALogin authentication(ALogin login){
		return loginMapper.authentication(login);
	}

}
