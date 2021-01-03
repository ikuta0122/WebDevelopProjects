package com.ikuta.beans;

import java.io.Serializable;

/*狭义的JavaBean
*该类必须是公共的[public]
*该类必须实现Serializable接口
*该类必须具备无参构造器
*该类的成员变量必须是私有的[private],并且提供getter和setter方法
*/
@SuppressWarnings("serial")
public class Student implements Serializable {
	// 业务无关主键
	private Integer id;
	// 登陆密码
	private String password;
	// 学号
	private String num;
	// 姓名
	private String name;
	// 年龄
	private int age;
	// 成绩
	private double score;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

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

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public Student() {
		super();
	}

	public Student(String num, String name, int age, double score) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", password=" + password + ", num=" + num + ", name=" + name + ", age=" + age
				+ ", score=" + score + "]";
	}

}
