package com.ikuta.listeners;

import com.ikuta.events.ICurdEvent;

//定义监听器类
public class CurdListener implements IListener {
	// 根据不同事件类型,执行不同操作
	@Override
	public void handle(ICurdEvent event) {
		String eventType = event.getEventType();
		if (ICurdEvent.CRE_EVENT.equals(eventType)) {
			System.out.println("事件源执行了添加操作");
		} else if (ICurdEvent.UPD_EVENT.equals(eventType)) {
			System.out.println("事件源执行了修改操作");
		} else if (ICurdEvent.RET_EVENT.equals(eventType)) {
			System.out.println("事件源执行了查询操作");
		} else if (ICurdEvent.DEL_EVENT.equals(eventType)) {
			System.out.println("事件源执行了删除操作");
		} else {
			System.out.println("错误操作");
		}
	}

}
