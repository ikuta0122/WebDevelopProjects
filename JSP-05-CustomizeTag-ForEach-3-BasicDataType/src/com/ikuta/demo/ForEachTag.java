package com.ikuta.demo;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
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
        } else if (items instanceof Object[]) {
            // 将数组转换为List
            // Arrays.asList()方法只能是用于引用数据类型数组
            // Arrays.asList()方法不能适用于基本数据类型数组
            return Arrays.asList((Object[]) items);
        } else if (items instanceof int[]) {
            // 需要提前准备一个集合用于存储基本数据类型数组中的元素,此处举例为List
            List nums = new ArrayList<>();
            // 遍历目标数组
            for (int num : (int[]) items) {
                nums.add(num);
            }
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

