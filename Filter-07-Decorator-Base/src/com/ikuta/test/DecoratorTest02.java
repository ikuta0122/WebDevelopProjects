package com.ikuta.test;

import com.ikuta.decorators.SomeServiceDecorator;
import com.ikuta.service.ISomeService;
import com.ikuta.service.SomeServiceImpl;

public class DecoratorTest02 {
	public static void main(String[] args) {
		// 创建目标对象
		ISomeService target = new SomeServiceImpl();
		// 创建装饰者对象
		ISomeService service = new SomeServiceDecorator(target);
		// 调用业务方法
		String result = service.doSome();
		System.out.println("result = " + result);
	}
}
