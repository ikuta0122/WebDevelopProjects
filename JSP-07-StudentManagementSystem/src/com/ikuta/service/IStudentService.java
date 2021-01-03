package com.ikuta.service;

import com.ikuta.beans.Student;

public interface IStudentService {

	// 对用户进行验证
	Student checkUser(String num, String password);

	// 向DB中添加Student
	Integer saveStudent(Student student);

}
