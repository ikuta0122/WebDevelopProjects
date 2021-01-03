package com.ikuta.demo;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class ForEachTag extends SimpleTagSupport {
    private Object items;
    private String var;

    public Collection getCollection() {
        if (items instanceof List) {
            return (List) items;
        } else if (items instanceof Set) {
            return (Set) items;
        } else if (items instanceof Map) {
            return ((Map) items).entrySet();
        } else if (items.getClass().isArray()) {// 判断items是否为一个数组
            List nums = new ArrayList<>();
            for (int i = 0; i < Array.getLength(items); i++)
                nums.add(Array.get(items, i));
            return nums;
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
