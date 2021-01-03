package com.ikuta.listeners;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {
	// 将当前session对象从List中删除
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// 获取当前session对象
		HttpSession currentSession = se.getSession();
		// 从当前session中获取当前ip
		String clientIp = (String) currentSession.getAttribute("clientIp");

		// 获取全局域
		ServletContext servletContext = currentSession.getServletContext();
		// 从全局与中获取Map
		@SuppressWarnings("unchecked")
		Map<String, List<HttpSession>> map = (Map<String, List<HttpSession>>) servletContext.getAttribute("map");
		// 从map中获取由当前ip所发出的所有的session组成的List
		List<HttpSession> sessions = map.get(clientIp);
		// 将当前session对象从List中删除
		sessions.remove(currentSession);
		// 如果List中没有元素,则说明当前Ip所发出的会话全部关闭
		// 那么,就可以从map中将当前ip所对应的Entry对象删除
		// 如果List中仍有元素,则说明当前Ip所发出的会话还有存在
		// 那么,将这个变化过的List写回到map中
		if (sessions.size() == 0) {
			map.remove(clientIp);
		} else {
			map.put(clientIp, sessions);
		}
		// 将修改过的map重新写回到全局域
		servletContext.setAttribute("map", map);
	}

}
