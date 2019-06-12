package com.qin.Interceptor;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.qin.utils.HibernateUtil;

/**
 * À¹½ØÆ÷
 * @author Administrator
 *
 */
public class OpenSessionInView extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			invocation.invoke();
			
			transaction.commit();
		} catch (Exception e) {
			
			//e.printStackTrace();
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
		}finally {
			HibernateUtil.closeSession();
		}
		
		return null;
	}

	
}
