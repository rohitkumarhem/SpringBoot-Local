package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.entities.Book;

@Component
public class BookService {

     private static List<Book> ls = new ArrayList<>();

    static {

	
	   ls.add(new Book(12, "Java complete Reference", "XYZ")); 
	   ls.add(new Book(36, "Head First to Java", "ABC")); 
	  ls.add(new Book(12963,"Thing in Java", "LMN"));
	 
	}
	 
     // get all books
     public List<Book> getAllBook() {
     return ls;
     }

     // get single book by id
     public Book getBookById(int id) {
     Book book = null;
     book = ls.stream().filter(e -> e.getId() == id).findFirst().get();

     return book;
     }
     
     //insert the record
     public Book addBook(Book book)
     {
    	 ls.add(book);
    	 return book;
     }
      //Delete
	public void deleteBook(int bookId) {
		// TODO Auto-generated method stub
		ls = ls.stream().filter(e-> e.getId()!=bookId).collect(Collectors.toList());
		
	}
}
