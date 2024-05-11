package com.firstcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class FirstDemo {
	
	public static void main(String[] args) {
		
		SessionFactory factory  = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		Student student = session.get(Student.class, 102);
		
		System.out.println(student);
		   
		System.out.println("Working something");
		
		Student student1 = session.get(Student.class, 102);
		
		System.out.println(student1);
		
		System.out.println(session.contains(student1));
		
		session.close();
		
		
	}

}
