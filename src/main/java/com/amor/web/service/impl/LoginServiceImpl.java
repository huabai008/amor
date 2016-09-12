package com.amor.web.service.impl;

import org.springframework.stereotype.Service;

import com.amor.web.mapper.AAuthorityMapper;
import com.amor.web.model.ALogin;
import com.amor.web.service.LoginService;

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
