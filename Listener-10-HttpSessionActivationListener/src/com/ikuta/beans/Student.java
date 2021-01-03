package com.ikuta.beans;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

/**
 * 实体类实现HttpSessionActivationListener接口
 * HttpSessionActivationListener不需要注册监听器
 * HttpSessionActivationListener同时还要实现Serializable接口
 */
public class Student implements HttpSessionActivationListener, Serializable {
    private static final long serialVersionUID = 1L;
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

    /**
     * 当前类的对象被活化时会触发该方法的执行
     */
    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        System.out.println("student已经被活化");
    }

    /**
     * 当前类的对象被钝化时会触发该方法的执行
     * 通过直接停止tomcat服务器模拟系统宕机,实现session钝化
     */
    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        System.out.println("student将要被钝化");
    }

}
