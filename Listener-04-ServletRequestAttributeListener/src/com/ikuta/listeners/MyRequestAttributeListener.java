package com.ikuta.listeners;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class MyRequestAttributeListener implements ServletRequestAttributeListener {

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("在request域中添加一个属性:" + srae.getName() + " = " + srae.getValue());
        // 在request域中添加一个属性:username = zhangsan
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.println("在request域中删除一个属性:" + srae.getName() + " = " + srae.getValue());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.println("在request域中修改一个属性:" + srae.getName() + " = " + srae.getValue());
    }

}
