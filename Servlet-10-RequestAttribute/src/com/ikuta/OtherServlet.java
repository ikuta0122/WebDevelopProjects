package com.ikuta;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class OtherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 从请求中获取请求名称的域属性
		String country = (String) request.getAttribute("country");
		String address = (String) request.getAttribute("address");
		System.out.println(country + "," + address);

		// 从请求中的所有域属性名称
		Enumeration<String> names = request.getAttributeNames();
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			System.out.println(name + "=" + request.getAttribute(name));

		}
	}
}
