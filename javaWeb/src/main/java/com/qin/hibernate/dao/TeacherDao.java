package com.qin.hibernate.dao;

import java.util.List;

import com.qin.pojo.Teacher;

public interface TeacherDao {

	List<Teacher> selectAll();
	
	void deleteById(Teacher teacher);
}
