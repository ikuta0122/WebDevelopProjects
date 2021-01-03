package com.ikuta;

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
		// 事件源注册监听器
		some.setListener(listener);
		// 事件源执行自己的业务方法
		some.saveStudent();
		some.removeStudent();
		some.modifyStudent();
		some.findStudent();
	}
}
