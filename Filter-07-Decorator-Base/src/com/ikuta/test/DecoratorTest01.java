package com.ikuta.test;

import com.ikuta.service.ISomeService;
import com.ikuta.service.SomeServiceImpl;

public class DecoratorTest01 {

	public static void main(String[] args) {
		ISomeService service = new SomeServiceImpl();
		String result = service.doSome();
		System.out.println("result = " + result);
	}

}
