package com.ikuta.demo;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class IfTag extends SimpleTagSupport {
    // ��ǩ�����Է�ӳ����ǩ����������,����һ��set����
    private boolean test;

    public void setTest(boolean test) {
        this.test = test;
    }

    @Override
    public void doTag() throws JspException, IOException {
        if (test) {
//			��ȡ��ǩ��
//			JspFragment jspBody = this.getJspBody();
//			����ǩ��д�뵽��׼�����
//			jspBody.invoke(this.getJspContext().getOut());

            // ���´���ȼ����������
            this.getJspBody().invoke(null);
        }
    }

}
