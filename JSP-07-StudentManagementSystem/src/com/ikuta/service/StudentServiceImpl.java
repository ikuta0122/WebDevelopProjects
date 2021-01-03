package com.ikuta.service;

import com.ikuta.beans.Student;
import com.ikuta.dao.IStudentDao;
import com.ikuta.dao.StudentDaoImpl;

public class StudentServiceImpl implements IStudentService {
	private IStudentDao dao;
	
	public StudentServiceImpl() {
		dao = new StudentDaoImpl();
	}

	@Override
	public Student checkUser(String num, String password) {
		return dao.selectStudentLogin(num,password);
	}

	@Override
	public Integer saveStudent(Student student) {
		return dao.insertStudent(student);
	}

}
