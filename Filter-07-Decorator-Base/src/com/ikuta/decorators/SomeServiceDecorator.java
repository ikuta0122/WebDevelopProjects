package com.ikuta.decorators;

import com.ikuta.service.ISomeService;

//装饰者类
public class SomeServiceDecorator implements ISomeService {
	private ISomeService target;
	
	public SomeServiceDecorator(ISomeService target) {
		super();
		this.target = target;
	}

	@Override
	public String doSome() {
		return target.doSome().toUpperCase();
	}

}
