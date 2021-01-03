package com.ikuta.demo;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

//定义标签处理器:获取客户端IP
public class ClientIpTag extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        // 获取pageContext对象
        PageContext pageContext = (PageContext) this.getJspContext();
        // 获取请求对象
        ServletRequest request = pageContext.getRequest();
        // 获取客户端ip
        String clientIp = request.getRemoteAddr();
        // 获取标准输出流对象
        JspWriter out = pageContext.getOut();
        // 将客户端ip写入到输出流中
        out.print(clientIp);
    }

}
