package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

@Component
public class BookService {

	@Autowired
	private BookRepository bookRepository;
//     private static List<Book> ls = new ArrayList<>();
//
//    static {
//
//	
//	   ls.add(new Book(12, "Java complete Reference", "XYZ")); 
//	   ls.add(new Book(36, "Head First to Java", "ABC")); 
//	  ls.add(new Book(12963,"Thing in Java", "LMN"));
//	 
//	}
	 
     // get all books
     public List<Book> getAllBook() {
      List<Book> list = (List<Book>) this.bookRepository.findAll();
      return list;
     }

     // get single book by id
     public Book getBookById(int id) {
    	 Book book = null;
    	 try { 
  //   book = ls.stream().filter(e -> e.getId() == id).findFirst().get();
    		  this.bookRepository.findById(id);
   
    	 }
    	 catch(Exception e)
    	 {
    		 e.printStackTrace();
    	 }
    	  return book;
     }
     
     //insert the record
     public Book addBook(Book book)
     {
    	 
    	  Book result = bookRepository.save(book);
    	  return result;
     }
      //Delete
	public void deleteBook(int bookId) {
		// TODO Auto-generated method stub
	//	ls = ls.stream().filter(e-> e.getId()!=bookId).collect(Collectors.toList());
		bookRepository.deleteById(bookId);
		
	}
  
	//update Handler
	
	public void updateBook(Book book, int bookId) {
		// TODO Auto-generated method stub
		
//		ls = ls.stream().map(e->
//		{
//			if(e.getId()==bookId)
//			{
//				e.setTitle(book.getTitle());
//				e.setAuthor(book.getAuthor());
//			}
//			return e;
//		}).collect(Collectors.toList());
		
		book.setId(bookId);
		bookRepository.save(book);
	
		
	}
}
