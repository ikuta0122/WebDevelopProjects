package com.ikuta.test;

import com.ikuta.proxy.SomeServiceProxy;
import com.ikuta.service.ISomeService;

public class StaticProxyTest {

	public static void main(String[] args) {
		ISomeService service = new SomeServiceProxy();
		String result = service.doSome();
		System.out.println("result = " + result);
	}

}
