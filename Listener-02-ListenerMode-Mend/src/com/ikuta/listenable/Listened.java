package com.ikuta.listenable;

import com.ikuta.events.CurdEvent;
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

	// 以下方法时事件源类的真正业务逻辑,而监听器监听的就是这些业务方法的执行
	public void saveStudent() {
		System.out.println("在DB中插入了一条数据");
		ICurdEvent event = new CurdEvent(this, "saveStudent");
		this.triggerListener(event);
	}

	public void removeStudent() {
		System.out.println("在DB中删除了一条数据");
		ICurdEvent event = new CurdEvent(this, "removeStudent");
		this.triggerListener(event);
	}

	public void modifyStudent() {
		System.out.println("在DB中修改了一条数据");
		ICurdEvent event = new CurdEvent(this, "modifyStudent");
		this.triggerListener(event);
	}

	public void findStudent() {
		System.out.println("在DB中查询了一条数据");
		ICurdEvent event = new CurdEvent(this, "findStudent");
		this.triggerListener(event);
	}

}
