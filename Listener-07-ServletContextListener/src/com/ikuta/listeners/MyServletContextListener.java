package com.ikuta.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ServletContext被创建");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ServletContext被销毁");
	}

}
