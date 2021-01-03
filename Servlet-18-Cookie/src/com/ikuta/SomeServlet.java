package com.ikuta;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 创建Cookie
        Cookie cookie1 = new Cookie("group", "nogizaka");
        Cookie cookie2 = new Cookie("idol", "ikuta");

        // 指定Cookie绑定的路径
        // 注意:此处指定路径要求必须添加项目名称
        // cookie1.setPath(request.getContextPath() + "/first/second/third");
        // cookie2.setPath(request.getContextPath() + "/first");

        // 设置Cookie的有效期
        // 注意1:值为整型值,单位为秒
        // 注意2:值大于0,表示该Cookie存储到客户端硬盘
        // 注意2:值等于0,表示该Cookie一生成马上失效
        // 注意2:值大于0,表示该Cookie存储到浏览器缓存,与不设置效果相同
        // cookie1.setMaxAge(60 * 60);// 设置Cookie的有效期为1小时
        // cookie2.setMaxAge(60 * 60 * 24 * 10);// 设置Cookie的有效期为10天

        // 向响应中添加Cookie
        response.addCookie(cookie1);
        response.addCookie(cookie2);
    }

}
