package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Certificate;
import com.tut.Student;

public class StateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Example: ");
		
		SessionFactory f = new Configuration().configure().buildSessionFactory();
		
		Student student = new Student();
		student.setId(14133);
		student.setName("Peter");
		student.setCity("London");
		student.setCerti(new Certificate("Hibernate Course","1 month")	);
		
		Session s = f.openSession();
		Transaction tx = s.beginTransaction();
		
		s.save(student);
		
		student.setName("John");
		
		tx.commit();
		
		s.close();
		 
		student.setName("Sachin");
		
		System.out.println(student);
		
		f.close();
		
	}

}
