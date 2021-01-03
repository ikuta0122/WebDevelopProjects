package com.ikuta.dao;

import com.ikuta.beans.Student;

public interface IStudentDao {

	Student selectStudentLogin(String num, String password);

	Integer insertStudent(Student student);


}
