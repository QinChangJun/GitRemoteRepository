package com.qin.hibernate.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.qin.hibernate.service.TeacherService;
import com.qin.hibernate.service.impl.TeacherServiceImpl;
import com.qin.pojo.Teacher;

@Namespace("/")
@ParentPackage("default")
public class TeacherAction extends ActionSupport {

	private TeacherService service = new TeacherServiceImpl();
	
	private List<Teacher> list = null;
	private Teacher teacher = null;
	
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Teacher> getList() {
		return list;
	}

	public void setList(List<Teacher> list) {
		this.list = list;
	}
	
	
	@Action(value = "show", results = @Result(type = "json", params = {"root", "list"}))
	public String show() {
		list = service.selectAll();
		
		return SUCCESS;
	}
	
	
	@Action(value = "delete")
	public void deleteById(Teacher teacher) {
		service.deleteById(teacher);
	}
	
}
