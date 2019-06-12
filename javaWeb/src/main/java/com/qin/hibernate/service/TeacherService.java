package com.qin.hibernate.service;

import java.util.List;

import com.qin.pojo.Teacher;

public interface TeacherService {

	List<Teacher> selectAll();
	
	void deleteById(Teacher teacher);
}
