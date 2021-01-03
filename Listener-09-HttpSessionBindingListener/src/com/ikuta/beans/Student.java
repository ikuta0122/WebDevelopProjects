package com.ikuta.beans;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * 实体类实现HttpSessionBindingListener接口
 * HttpSessionBindingListener不需要注册监听器
 */
public class Student implements HttpSessionBindingListener {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student() {
        super();
    }

    public Student(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("student对象与session绑定 :" + event.getName() + " = " + event.getValue());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("student对象与session解绑 :" + event.getName() + " = " + event.getValue());
    }

}
