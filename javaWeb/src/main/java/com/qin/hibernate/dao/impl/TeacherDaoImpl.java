package com.qin.hibernate.dao.impl;

import java.util.List;

import com.qin.hibernate.dao.TeacherDao;
import com.qin.pojo.Teacher;
import com.qin.utils.HibernateUtil;

public class TeacherDaoImpl implements TeacherDao{

	@Override
	public List<Teacher> selectAll() {
		
		return HibernateUtil.getSession().createQuery("from Teacher", Teacher.class).getResultList();
	}

	@Override
	public void deleteById(Teacher teacher) {
		
		HibernateUtil.getSession().delete(teacher);
	}

}
