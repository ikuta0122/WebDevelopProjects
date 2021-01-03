package com.ikuta.demo;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;

public class ForEachListTag extends SimpleTagSupport {
    private List items;
    // 当前遍历对象要放入与空间的属性名
    private String var;

    @SuppressWarnings("rawtypes")
    public void setItems(List items) {
        this.items = items;
    }

    public void setVar(String var) {
        this.var = var;
    }

    @Override
    public void doTag() throws JspException, IOException {
        for (Object obj : items) {
            // 因为EL表达式只能从四大域空间中获取数据
            // 所以将当前遍历对象放入page域空间中
            // 其value为var所指定的名称,而value为当前遍历对象obj
            this.getJspContext().setAttribute(var, obj);
            this.getJspBody().invoke(null);
        }
    }

}
