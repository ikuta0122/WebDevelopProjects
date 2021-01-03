package com.ikuta.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyRequestListener implements ServletRequestListener {
	// 将当前session对象存放到List中
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		// 获取当前request
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
		// 获取当前ip
		String clientIp = request.getRemoteAddr();
		// 获取当前session对象
		HttpSession currentSession = request.getSession();

		// 获取全局域
		ServletContext servletContext = sre.getServletContext();
		// 从全局域中获取map
		Map<String, List<HttpSession>> map = (Map<String, List<HttpSession>>) servletContext.getAttribute("map");
		// 从map中获取由当前ip所发出的所有的session组成的List
		List<HttpSession> sessions = map.get(clientIp);
		// 判断当前的List是否为null
		// 如果为null,则创建List
		// 如果不为null,将当前session对象存放到List中
		if (sessions == null) {
			sessions = new ArrayList<>();
		}
		// 遍历List,如果List中存在当前session对象,则不用操作List
		for (HttpSession session : sessions) {
			if (session == currentSession) {
				return;
			}
		}
		// 将当前session对象存放到List中
		sessions.add(currentSession);

		// 将修改过的List重新写回到map
		map.put(clientIp, sessions);
		// 将修改过的map重新写回到全局域
		servletContext.setAttribute("map", map);

		// 将当前ip放入到当前session
		currentSession.setAttribute("clientIp", clientIp);
	}
}
