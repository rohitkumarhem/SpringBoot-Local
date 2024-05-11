package com.tut;

import javax.persistence.Embeddable;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class EmDemo {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Student student1 = new Student();
		
		student1.setId(1112);
		student1.setName("Rohit");
		student1.setCity("Ranchi");

		Certificate certificate  = new Certificate();
		
		certificate.setCourse("Spring boot");
		certificate.setDuration("3 month");
		
		student1.setCerti(certificate);
		
		//student2

   Student student2 = new Student();
		
		student2.setId(2223);
		student2.setName("Rahul");
		student2.setCity("Ramgarh");

		Certificate certificate2  = new Certificate();
		
		certificate2.setCourse("Spring");
		certificate2.setDuration("5 month");
		
		student2.setCerti(certificate2);
		
		Session s = factory.openSession();
		
		Transaction tx = s.beginTransaction();
		
		s.save(student1);
		s.save(student2);
		
		tx.commit();
		s.close();
		factory.close();
	}
	
}
