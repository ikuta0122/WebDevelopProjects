package com.ikuta.demo;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

//定义标签处理器:将源字符串中的字符转换为大写形式
public class LowerToUpperTag extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        // 获取标签体对象
        JspFragment jspBody = this.getJspBody();
        // 创建一个输出流,该流中的内容可通过其toString()获取其文本形式
        StringWriter stringWriter = new StringWriter();
        // 将标签体内容写入到输出流中
        jspBody.invoke(stringWriter);
        // 以文本形式获取到流出流的内容
        String content = stringWriter.toString();
        // 小写变大写
        content = content.toUpperCase();
        // 获取标准输出流对象
        JspWriter out = this.getJspContext().getOut();
        // 将转换为大写形式的内容写入到标准输出流中
        out.print(content);
    }

}
