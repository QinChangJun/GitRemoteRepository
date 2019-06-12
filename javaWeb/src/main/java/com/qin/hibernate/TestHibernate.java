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
		
		//���ϴ���ʹ�ù������װ
		Session session = HibernateUtil.getSession();
		
		//��ѯȫ��
		Query<Student> query = session.createQuery("from Student", Student.class);
		List<Student> list = query.getResultList();
		
		for (Student student : list) {
			System.out.println(student);
		}
		 
		
		
		
		
		
		
		//��ѯ
		//Teacher teacher = session.get(Teacher.class, "1");
		
		
		//��������
		Transaction ts = session.beginTransaction();

		
		try {
			//����
			//Teacher teacher = new Teacher("4", "����", "11", "���꼶�İ�", "3333", "��", "������");
			//session.save(teacher);
			
			//�ύ����
			ts.commit();
			
		} catch (Exception e) {
			//e.printStackTrace();
			if (ts != null && ts.isActive()) {
				ts.rollback();
			}
			System.out.println("���ݿ����ʧ�ܣ�");
		} finally {
			//�ر�SessionFactory
			//factory.close();
//			session.close();
//			StandardServiceRegistryBuilder.destroy(registry);
			HibernateUtil.closeSession();
			
		}
		
		
		
		
		
		
		

	}

}
