package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class FetchDemo {
	
	public static void main(String[] args)
	{
		//get load method
		
		Configuration cfg = new Configuration();
		
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory  = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Student student = (Student)session.load(Student.class, 101);
		
		System.out.println(student);
		
	    Address address=  (Address)session.get(Address.class, 1);
	    
	    System.out.println(address);
		
	
		
		session.close();
		factory.close();
		
	}

}
