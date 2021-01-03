package com.ikuta.listenable;

import com.ikuta.events.ICurdEvent;
import com.ikuta.listeners.IListener;

//定义事件源接口
public interface IListenable {
    // 为事件源注册监听器
    void setListener(IListener listener);

    //触发监听器
    void triggerListener(ICurdEvent event);
}
