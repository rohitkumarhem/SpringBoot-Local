package com.api.book.bootrestbook.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

     @GetMapping("/books")
     public List<Book> getBooks() {
     return this.bookService.getAllBook();
     }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") int id) {
        return this.bookService.getBookById(id);
    }
    
    @PostMapping("/books")
    public Book addBook(@RequestBody Book b)
    {
    	Book book =this.bookService.addBook(b);
    	return book;
    }
    
    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId)
    {
    	this.bookService.deleteBook(bookId);
    }

}
