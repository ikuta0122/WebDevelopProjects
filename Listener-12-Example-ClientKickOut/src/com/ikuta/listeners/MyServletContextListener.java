package com.ikuta.listeners;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 创建一个Map,key为用户名,value为与当前用户绑定的session对象
		Map<String, HttpSession> map = new HashMap<>();
		// 获取到全局域
		ServletContext servletContext = sce.getServletContext();
		// 将map放入到全局域
		servletContext.setAttribute("map", map);
	}

}
