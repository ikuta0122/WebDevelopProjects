package com.ikuta.listeners;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class MyServletContextAttributeListener implements ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent scae) {
		System.out.println("在ServletContext中添加一个属性: " + scae.getName() + " = " + scae.getValue());
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent scae) {
		System.out.println("在ServletContext中删除一个属性: " + scae.getName() + " = " + scae.getValue());
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent scae) {
		System.out.println("在ServletContext中修改一个属性: " + scae.getName() + " = " + scae.getValue());
	}

}
