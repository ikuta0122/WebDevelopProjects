package com.ikuta.decorators;

import com.ikuta.service.ISomeService;

//装饰者类的基类
//要求1:要有无参构造器
//要求2:不对目标类的目标方法进行任何增强
public class SomeServiceWrapper implements ISomeService {
	// 目标对象
	private ISomeService target;

	public SomeServiceWrapper() {
		super();
	}

	public SomeServiceWrapper(ISomeService target) {
		super();
		this.target = target;
	}

	@Override
	public String doSome() {
		// 调用目标类的目标方法,但不对其进行任何的增强
		return target.doSome();
	}

}
