package com.ikuta.service;

import com.ikuta.beans.Student;

public interface IStudentService {

	// ���û�������֤
	Student checkUser(String num, String password);

	// ��DB�����Student
	Integer saveStudent(Student student);

}
