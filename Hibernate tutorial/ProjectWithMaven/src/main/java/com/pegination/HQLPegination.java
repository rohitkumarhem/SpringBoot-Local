package com.pegination;

import org.hibernate.query.*;

import com.tut.Student;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HQLPegination {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session s  =factory.openSession();
		
		Query query = s.createQuery("from Student");
		
		query.setFirstResult(0);
		
		query.setMaxResults(4);
		
		List<Student> list = query.list();
		
		for(Student student: list)
		{
			System.out.println("id : "+ student.getId() + "City : " +
		   student.getCity() + "Name : " + student.getName());
		}
		
		
		s.close();
		
		factory.close();
		
		
	}

}
