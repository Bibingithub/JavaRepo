package com.bibin.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtil {
	
	public static SessionFactory sf = null;
	
	 static  {
		
		Configuration cfg = new Configuration();
		cfg.configure("com/bibin/cfgfiles/hibernate.cfg.xml");
		
		sf =  cfg.buildSessionFactory();
	}
	
	public static Session getSession() {
		Session session = sf.openSession();
		return session;
	}
	
	public static void closeSession(Session session) {
		if(session != null)
		session.close();
	}

}
