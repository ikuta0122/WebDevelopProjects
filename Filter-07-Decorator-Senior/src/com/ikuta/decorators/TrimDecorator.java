package com.ikuta.decorators;

import com.ikuta.service.ISomeService;

//具体装饰者
//要求1:要继承自装饰者基类
//要求2:要有带参构造器
//要求3:具体装饰者只对装饰着基类业务方法进行某一种单一的增强
public class TrimDecorator extends SomeServiceWrapper {
	public TrimDecorator() {
		super();
	}

	public TrimDecorator(ISomeService target) {
		super(target);
	}

	// 重写基类的业务方法
	@Override
	public String doSome() {
		// 调用基类的业务方法,并对其进行增强
		return super.doSome().trim();
	}

}
