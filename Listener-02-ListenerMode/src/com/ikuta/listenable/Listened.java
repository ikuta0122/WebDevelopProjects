package com.ikuta.listenable;

import com.ikuta.events.ICurdEvent;
import com.ikuta.listeners.IListener;

//定义事件源类
public class Listened implements IListenable {
    private IListener listener;

    // 注册监听器
    @Override
    public void setListener(IListener listener) {
        this.listener = listener;
    }

    // 触发监听器
    @Override
    public void triggerListener(ICurdEvent event) {
        listener.handle(event);
    }

}
