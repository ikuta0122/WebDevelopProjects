package com.ikuta.demo;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

//�����ǩ������:��Դ�ַ����е��ַ�ת��Ϊ��д��ʽ
public class LowerToUpperTag extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        // ��ȡ��ǩ�����
        JspFragment jspBody = this.getJspBody();
        // ����һ�������,�����е����ݿ�ͨ����toString()��ȡ���ı���ʽ
        StringWriter stringWriter = new StringWriter();
        // ����ǩ������д�뵽�������
        jspBody.invoke(stringWriter);
        // ���ı���ʽ��ȡ��������������
        String content = stringWriter.toString();
        // Сд���д
        content = content.toUpperCase();
        // ��ȡ��׼���������
        JspWriter out = this.getJspContext().getOut();
        // ��ת��Ϊ��д��ʽ������д�뵽��׼�������
        out.print(content);
    }

}
