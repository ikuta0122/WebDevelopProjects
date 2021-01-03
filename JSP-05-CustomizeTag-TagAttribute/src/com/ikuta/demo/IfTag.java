package com.ikuta.demo;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class IfTag extends SimpleTagSupport {
    // 标签的属性反映到标签处理器类中,就是一个set属性
    private boolean test;

    public void setTest(boolean test) {
        this.test = test;
    }

    @Override
    public void doTag() throws JspException, IOException {
        if (test) {
//			获取标签体
//			JspFragment jspBody = this.getJspBody();
//			将标签体写入到标准输出流
//			jspBody.invoke(this.getJspContext().getOut());

            // 以下代码等价于上面代码
            this.getJspBody().invoke(null);
        }
    }

}
