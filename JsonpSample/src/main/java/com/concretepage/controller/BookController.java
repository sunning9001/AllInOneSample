package com.concretepage.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.concretepage.bean.Book;
@Controller
class BookController {
    @RequestMapping(value ="/book2", produces =MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    Book bookInfo2() {
    	Book book = new Book();
    	book.setBookName("Ramcharitmanas");
    	book.setWriter("TulasiDas");
    	return book;
    }
    @RequestMapping(value ="/book3", produces =MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Book> bookInfo3() {
    	Book book = new Book();
    	book.setBookName("Ramayan");
    	book.setWriter("Valmiki");
        return ResponseEntity.accepted().body(book);
    } 
}