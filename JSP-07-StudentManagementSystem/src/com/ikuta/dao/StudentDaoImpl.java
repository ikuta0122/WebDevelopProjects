package com.ikuta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ikuta.beans.Student;
import com.ikuta.utils.JdbcUtils;

public class StudentDaoImpl implements IStudentDao {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	@Override
	public Student selectStudentLogin(String num, String password) {
		Student student = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from student where num=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, num);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				student = new Student();
				student.setId(rs.getInt("id"));
				student.setNum(rs.getString("num"));
				student.setPassword(rs.getString("password"));
				student.setName(rs.getString("name"));
				student.setAge(rs.getInt("age"));
				student.setScore(rs.getDouble("score"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtils.close(conn, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return student;
	}

	@Override
	public Integer insertStudent(Student student) {
		Integer id = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into student(num,password,name,age,score) values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, student.getNum());
			ps.setString(2, student.getPassword());
			ps.setString(3, student.getName());
			ps.setInt(4, student.getAge());
			ps.setDouble(5, student.getScore());
			ps.executeUpdate();

			// 验证是否插入成功
			sql = "select @@identity newId";
			// sql = "select last_insert_id() newId";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				id = rs.getInt("newId");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtils.close(conn, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return id;
	}

}
