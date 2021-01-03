package com.ikuta.decorators;

import com.ikuta.service.ISomeService;

public class ToUpperCaseDecorator extends SomeServiceWrapper {

	public ToUpperCaseDecorator() {
		super();
	}

	public ToUpperCaseDecorator(ISomeService target) {
		super(target);
	}

	@Override
	public String doSome() {
		return super.doSome().toUpperCase();
	}

}
