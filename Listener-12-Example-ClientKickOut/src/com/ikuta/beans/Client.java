package com.ikuta.beans;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Client implements HttpSessionBindingListener {
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Client() {
		super();
	}

	public Client(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Client [name=" + name + ", age=" + age + "]";
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		// 获取当前session
		HttpSession session = event.getSession();
		// 获取到全局域
		ServletContext servletContext = session.getServletContext();
		// 从全局域中获取map
		@SuppressWarnings("unchecked")
		Map<String, HttpSession> map = (Map<String, HttpSession>) servletContext.getAttribute("map");
		// 将当前用户名与session放入map中
		map.put(name, session);
		// 将map写入到全局域
		servletContext.setAttribute("map", map);
	}

}
