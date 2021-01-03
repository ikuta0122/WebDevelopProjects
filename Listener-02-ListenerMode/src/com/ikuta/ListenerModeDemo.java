package com.ikuta;

import com.ikuta.events.CurdEvent;
import com.ikuta.events.ICurdEvent;
import com.ikuta.listenable.IListenable;
import com.ikuta.listenable.Listened;
import com.ikuta.listeners.CurdListener;
import com.ikuta.listeners.IListener;

public class ListenerModeDemo {

	public static void main(String[] args) {
		// 定义监听器
		IListener listener = new CurdListener();
		// 定义事件源
		IListenable some = new Listened();
		// 定义事件对象
		ICurdEvent event = new CurdEvent(some, "saveStudent");
		// 事件源注册监听器
		some.setListener(listener);
		// 事件源触发监听器
		some.triggerListener(event);

	}

}
