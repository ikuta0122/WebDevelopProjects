package com.ikuta.events;

import com.ikuta.listenable.IListenable;

//	定义增删改查事件
//	C:Create	增加
//	U:Update	修改
//	R:Retrieve	检索
//	D:Delete	删除

//	通常对于事件对象,需要从事件对象中获取到事件源对象
public interface ICurdEvent {
	// 声明事件类型
	String CRE_EVENT = "create event";
	String UPD_EVENT = "update event";
	String RET_EVENT = "retrieve event";
	String DEL_EVENT = "delete event";

	// 获取事件源对象
	IListenable getEventSource();

	// 获取事件类型
	String getEventType();
}
