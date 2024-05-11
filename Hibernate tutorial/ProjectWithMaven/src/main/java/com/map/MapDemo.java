package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		//creating question
		Question q1=new Question();
		q1.setQuestionId(1212);
		q1.setQuestion("what is Java ?");
		
		//Creating Answer
		
		Answer answer = new Answer();
		answer.setAnswerId(343);
		answer.setAnswer("Java is Programming Language");
		answer.setQuestion(q1);
		
		Answer answer1 = new Answer();
		answer1.setAnswerId(342);
		answer1.setAnswer("with the help of java we can create software");
		answer1.setQuestion(q1);
		
		Answer answer2 = new Answer();
		answer2.setAnswerId(344);
		answer2.setAnswer("Java has diffrent frameworks");
		answer2.setQuestion(q1);

		List<Answer> list= new ArrayList<Answer>();
		
		list.add(answer);
		list.add(answer1);
		list.add(answer2);
		
		q1.setAnswer(list);
		
	
		
		//session
		Session session  = factory.openSession();
		Transaction tx = session.beginTransaction();
		
//	      session.save(q1);
//	      session.save(answer);
//	      session.save(answer1);
//	      session.save(answer2);
		
		Question q = (Question)session.get(Question.class, 1212);
		
		System.out.println(q.getQuestionId());
		System.out.println(q.getQuestion());
		
		System.out.println(q.getAnswer().size());
		
//		System.out.println(q.getQuestion());
	
//		
//		for(Answer a : q.getAnswer())
//		{
//			System.out.println(a.getAnswer());
//		}
//		
		tx.commit();
		
		session.close();
		
		factory.close();
		
	}

}
