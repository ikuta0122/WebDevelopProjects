package com.ikuta.demo;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.*;

public class ForEachTag_two extends SimpleTagSupport {
    private Object items;
    private String var;

    @SuppressWarnings("rawtypes")
    public Collection getCollection() {
        if (items instanceof List) {
            return (List) items;
        } else if (items instanceof Set) {
            return (Set) items;
        } else if (items instanceof Map) {
            return ((Map) items).entrySet();
        } else if (items instanceof Object[]) {
            // 将数组转换为List
            return Arrays.asList((Object[]) items);
        } else {
            return null;
        }
    }

    public void setItems(Object items) {
        this.items = items;
    }

    public void setVar(String var) {
        this.var = var;
    }

    @Override
    public void doTag() throws JspException, IOException {
        for (Object obj : getCollection()) {
            this.getJspContext().setAttribute(var, obj);
            this.getJspBody().invoke(null);
        }
    }
}
