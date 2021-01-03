package com.ikuta.listeners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("Session被创建");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("Session被销毁");
	}

}
