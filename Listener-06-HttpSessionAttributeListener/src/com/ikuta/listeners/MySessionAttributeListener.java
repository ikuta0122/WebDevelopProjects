package com.ikuta.listeners;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MySessionAttributeListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		System.out.println("在Session中添加一个属性: " + se.getName() + " = " + se.getValue());
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("在Session中删除一个属性: " + se.getName() + " = " + se.getValue());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("在Session中修改一个属性: " + se.getName() + " = " + se.getValue());
	}

}
