package com.qin.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static String CONFIG_FILE_LOCATION="/hibernate.cfg.xml";
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	private static StandardServiceRegistry registry;
	private static SessionFactory factory;
	/**
	 * 使用静态代码块让sessionFactory在类加载的时候就进行实例化。
	 */
	static{
		try {
			//获取到Hibernate.cfg.xml配置文件对象
			registry = new StandardServiceRegistryBuilder().configure(CONFIG_FILE_LOCATION).build();
		} catch (Exception e) {
			System.err.println("加载hibernate配置文件出错");
			e.printStackTrace();
		}
		try {
			//根据配置文件，无论是否使用注解方式都可以实例化对应的SessionFactory.注意声明信息处理类MetadataSource的构造方法参数
			factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			System.err.println("构建SessionFactor出现错误");
			e.printStackTrace();
		}
	}
	/**
	 * 提供空的HibernateUtil，防止用户实例化HibernateUtil
	 */
	private HibernateUtil(){
	}
	
	/**
	 * 当获取Session对象的时候如果sessionfactory为空，可以调用此方法
	 */
	public static void rebuildSessionFactory(){
		try {
			registry = new StandardServiceRegistryBuilder().configure().build();
		} catch (Exception e) {
			System.err.println("加载hibernate配置文件出错");
			e.printStackTrace();
		}
		try {
			factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			System.err.println("构建SessionFactor出现错误");
			e.printStackTrace();
		}
	}
	/**
	 * 获取session对象
	 * @return
	 */
	public static Session getSession() {
		Session session = threadLocal.get();
		if(session==null || !session.isOpen()){
			if(factory==null){
				rebuildSessionFactory();
			}
			session = (factory!=null)?factory.openSession():null;
			threadLocal.set(session);
		}
		return session;
	}
	/**
	 * 关闭session
	 * 关闭时需要清空ThreadLocal中内容和关闭session
	 */
	public static void closeSession(){
		Session session = threadLocal.get();
		threadLocal.set(null);
		if(session!=null){
			session.close();
		}
	}
}
