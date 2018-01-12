package com.concretepage.restservice;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.concretepage.bean.Book;
@RestController
class BookService {
    @RequestMapping(value= "/book1", produces = MediaType.APPLICATION_JSON_VALUE)
    Book bookInfo1() {
    	Book book = new Book();
    	book.setBookName("Godan");
    	book.setWriter("Premchand");
        return book;
    }
}