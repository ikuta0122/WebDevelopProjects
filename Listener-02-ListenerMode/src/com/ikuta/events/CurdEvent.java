package com.ikuta.events;

import com.ikuta.listenable.IListenable;

//定义事件类
public class CurdEvent implements ICurdEvent {
	// 事件源
	private IListenable eventSource;
	// 事件源所执行的方法名称
	private String methodName;

	public CurdEvent(IListenable eventSource, String methodName) {
		super();
		this.eventSource = eventSource;
		this.methodName = methodName;
	}

	@Override
	public IListenable getEventSource() {
		return eventSource;
	}

	// 根据事件源所执行的不同方法,返回不同的事件类型
	@Override
	public String getEventType() {
		String eventType = null;
		if (methodName.startsWith("save")) {
			eventType = CRE_EVENT;
		} else if (methodName.startsWith("modify")) {
			eventType = UPD_EVENT;
		} else if (methodName.startsWith("find")) {
			eventType = RET_EVENT;
		} else if (methodName.startsWith("remove")) {
			eventType = DEL_EVENT;
		} else {
			eventType = "have no this event type";
		}
		return eventType;
	}

}
