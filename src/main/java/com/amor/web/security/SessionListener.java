package com.amor.web.security;

import javax.websocket.Session;

import org.apache.shiro.session.SessionListenerAdapter;

public class SessionListener extends SessionListenerAdapter{
	
	public void onStart(Session session){
		System.out.println("start session : " + session.getId());
	}
	
	public void onStop(Session session) {
		System.out.println("stop session : " + session.getId());
	}
}
