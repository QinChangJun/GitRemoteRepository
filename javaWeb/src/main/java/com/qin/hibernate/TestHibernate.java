package com.qin.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.qin.pojo.Student;
import com.qin.utils.HibernateUtil;

public class TestHibernate {

	public static void main(String[] args) {
		//Hibernate5
//		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
//		SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
//		Session session = factory.openSession();
		
		//以上代码使用工具类封装
		Session session = HibernateUtil.getSession();
		
		//查询全部
		Query<Student> query = session.createQuery("from Student", Student.class);
		List<Student> list = query.getResultList();
		
		for (Student student : list) {
			System.out.println(student);
		}
		 
		
		
		
		
		
		
		//查询
		//Teacher teacher = session.get(Teacher.class, "1");
		
		
		//开启事务
		Transaction ts = session.beginTransaction();

		
		try {
			//新增
			//Teacher teacher = new Teacher("4", "赵六", "11", "六年级四班", "3333", "男", "郸城县");
			//session.save(teacher);
			
			//提交事务
			ts.commit();
			
		} catch (Exception e) {
			//e.printStackTrace();
			if (ts != null && ts.isActive()) {
				ts.rollback();
			}
			System.out.println("数据库操作失败！");
		} finally {
			//关闭SessionFactory
			//factory.close();
//			session.close();
//			StandardServiceRegistryBuilder.destroy(registry);
			HibernateUtil.closeSession();
			
		}
		
		
		
		
		
		
		

	}

}
