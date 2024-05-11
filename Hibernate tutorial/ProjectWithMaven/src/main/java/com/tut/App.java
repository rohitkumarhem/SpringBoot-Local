package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project Started !!!" );
        
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
   
        SessionFactory factory = cfg.buildSessionFactory();
        
        //creating Student
        Student st = new Student();
        st.setId(105);
        st.setName("Sameer");
         st.setCity("Durgapur");
         
         //Creating Address Object
         Address ad  = new Address();
         ad.setStreet("street1");
         ad.setCity("Ramgarh");
         ad.setOpen(true);
         ad.setAddedDate(new Date());
         ad.setX(123.123);
         
         //Reading Image
         
         FileInputStream fis = new FileInputStream("src/main/java/rahul_Signature.jpeg");
        
         byte[] data = new byte[fis.available()];
         fis.read(data);
         ad.setImage(data);
         
       Session session = factory.openSession();
       
       Transaction tx= session.beginTransaction();
       
          session.save(st);
          session.save(ad);
          tx.commit();
          
          session.close();
          
      
      
    }
}
