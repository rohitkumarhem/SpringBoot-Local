package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class HQLExample { 
	
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session s = factory.openSession();
		
		String query  = "from Student as s where s.city=:x and s.name=:y";
		
		Query q = s.createQuery(query);
		
		q.setParameter("x", "Ramgarh");
		q.setParameter("y", "Rohit");
		
		List<Student> list = q.list();
		
		for(Student student : list)
		{
			System.out.println(student.getName());
		}
		
		System.out.println("-----------------------------------------");
		
		//delete the Record
		
		Transaction tx = s.beginTransaction();
//		
//		Query  q2 = s.createQuery("delete from Student where city=:x");
//		
//		q2.setParameter("x", "Ramgarh");
//		int r = q2.executeUpdate();
//		
//		System.out.println(r + "Record Deleted");
		
		Query q2 = s.createQuery("update Student set city=:x where name=:y");
		
		q2.setParameter("x", "Ramgarh");
		q2.setParameter("y", "Sameer");
		
		int r = q2.executeUpdate();
		
		System.out.println(r + "records Updated");
		
		tx.commit();
		//Join Query
		
		Query q3 = s.createQuery("select q.question, q.questionId, a.answer from Question q Inner Join q.answer a");
		
		List<Object[]> list3=q3.getResultList();
		
		for(Object[] arr: list3)
		{
			System.out.println(Arrays.toString(arr));
		}
		
		
		s.close();
		factory.close();

	}
	
}
