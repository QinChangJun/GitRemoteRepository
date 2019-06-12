package com.qin.hibernate.service.impl;

import java.util.List;

import com.qin.hibernate.dao.TeacherDao;
import com.qin.hibernate.dao.impl.TeacherDaoImpl;
import com.qin.hibernate.service.TeacherService;
import com.qin.pojo.Teacher;

public class TeacherServiceImpl implements TeacherService{

	TeacherDao dao = new TeacherDaoImpl();
	
	
	@Override
	public List<Teacher> selectAll() {
		
		return dao.selectAll();
	}


	@Override
	public void deleteById(Teacher teacher) {
		
		dao.deleteById(teacher);
	}

}
