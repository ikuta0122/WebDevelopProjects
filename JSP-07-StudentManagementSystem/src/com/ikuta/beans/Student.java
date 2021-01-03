package com.ikuta.beans;

import java.io.Serializable;

/*�����JavaBean
*��������ǹ�����[public]
*�������ʵ��Serializable�ӿ�
*�������߱��޲ι�����
*����ĳ�Ա����������˽�е�[private],�����ṩgetter��setter����
*/
@SuppressWarnings("serial")
public class Student implements Serializable {
	// ҵ���޹�����
	private Integer id;
	// ��½����
	private String password;
	// ѧ��
	private String num;
	// ����
	private String name;
	// ����
	private int age;
	// �ɼ�
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
