package com.ikuta.listeners;

import com.ikuta.events.ICurdEvent;

//定义监听器接口
public interface IListener {
	// 处理事件
	void handle(ICurdEvent event);
}
