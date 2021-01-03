package com.ikuta;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取指定参数的值
        // getParameter("name")方法本质上等同于getParameterValues("name")[0]
        String name = request.getParameter("name");
        String ageStr = request.getParameter("age");
        Integer age = Integer.valueOf(ageStr);
        System.out.println("name = " + name);
        System.out.println("age = " + age);

        // 获取所有请求参数名称
        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()) {
            String parameterName = names.nextElement();
            String parameterValue = request.getParameter(parameterName);
            System.out.println(parameterName + " = " + parameterValue);
        }

        // 获取指定参数的所有值
        String[] hobby = request.getParameterValues("hobby");
        for (String h : hobby) {
            System.out.println("hobby = " + h);
        }

        // 获取存放请求参数的Map
        Map<String, String[]> map = request.getParameterMap();
        for (String key : map.keySet()) {
            System.out.println(key + "---" + request.getParameter(key));
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
