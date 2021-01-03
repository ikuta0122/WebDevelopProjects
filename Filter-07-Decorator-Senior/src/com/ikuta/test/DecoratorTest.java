package com.ikuta.test;

import com.ikuta.decorators.ToUpperCaseDecorator;
import com.ikuta.decorators.TrimDecorator;
import com.ikuta.service.ISomeService;
import com.ikuta.service.SomeServiceImpl;

public class DecoratorTest {
	public static void main(String[] args) {
		// 创建目标对象
		ISomeService target = new SomeServiceImpl();
		// 创建装饰者对象
		ISomeService service1 = new TrimDecorator(target);
		// 将第一次增强过的结果作为第二次增强的参数,形成"装饰者链"
		ISomeService service2 = new ToUpperCaseDecorator(service1);
		// 调用业务方法
		String result = service2.doSome();
		System.out.println("result = " + result);
	}
}
