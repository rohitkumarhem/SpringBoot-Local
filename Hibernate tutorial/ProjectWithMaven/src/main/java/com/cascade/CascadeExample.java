package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.Answer;
import com.map.Question;

public class CascadeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	   SessionFactory factory = new Configuration().configure().buildSessionFactory();
	   
	   Session s = factory.openSession();
	   
	   Transaction tx = s.beginTransaction();
	   
	   Question q = new Question();
	   
	   q.setQuestionId(5625);
	   q.setQuestion("What is Swing Framework");
	   
	   Answer a1 = new Answer(231423, " Use for Development",q);
	   Answer a2 = new Answer(2515, "Desktop",q);
	   Answer a3 = new Answer(315, "Learn by Programmer",q);
	   
	   List<Answer> list = new ArrayList<Answer>();
	   
	   list.add(a1);
	   list.add(a2);
	   list.add(a3);
	   
	   q.setAnswer(list);
	   
	   s.save(q);
	   tx.commit();
	   s.close();
	   factory.close();
	   

	}

}
