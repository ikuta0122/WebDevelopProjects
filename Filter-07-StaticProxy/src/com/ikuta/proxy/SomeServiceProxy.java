package com.ikuta.proxy;

import com.ikuta.service.ISomeService;
import com.ikuta.service.SomeServiceImpl;

//静态代理类
/*静态代理类与装饰者之间的共同点
1.都要实现与目标类相同的业务接口
2.都要声明目标对象
3.都可以在不修改目标类的前提下,增强目标方法
*/
/*静态代理类与装饰者之间的不同点
1.目的不同
	1)装饰者类的使用目的在于增强目标对象
	2)静态代理的使用目的在于保护和隐藏目标对象
2.目标对象的获取方式不同
	1)装饰者类中目标对象通过[带参构造器]传入
	2)静态代理中目标对象通过[无参构造器]创建
3.功能增强的实现者不同
	1)装饰者设计模式中存在装饰者基类[不真正实现增强]和具体装饰者[真正实现增强]
	所以,装饰者设计模式中存在"链"的概念
	2)静态代理设计模式中一般不存在父子类的关系,功能增强的实现者就是代理类,
	所以,静态代理设计模式中不存在"链"的概念
*/
public class SomeServiceProxy implements ISomeService {
    private ISomeService target;

    // 在无参构造器中创建目标对象
    public SomeServiceProxy() {
        target = new SomeServiceImpl();
    }

    @Override
    public String doSome() {
        return target.doSome().toUpperCase();
    }
}
