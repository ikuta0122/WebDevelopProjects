package com.ikuta.listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyRequestListener implements ServletRequestListener {
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("Listener动态注册成功");
	}
}
