package com.ikuta.listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyRequestListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("请求对象被销毁");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("请求对象被创建");
    }

}
