package com.example1.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example1.dto.Author;
import com.example1.dto.AuthorMessage;
import com.example1.dto.AuthorMessageResponse;
import com.example1.service.AuthorService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/author")
public class AuthorController {

	@Autowired 
	private AuthorService authorService; 
	
	@GetMapping(path = "/{id}")
	public Mono<Author> get(@PathVariable("id") String id) {
		return authorService.loadUserFromComplexSystem(id);
	}
	
	
	 @RequestMapping(path = "/sendMessage", method = RequestMethod.POST)
	    public Flux<AuthorMessageResponse> handleMessageFlux(@RequestBody AuthorMessage message) {
	        return authorService.sendMessageToAuthor(message);
	    }

	 
}
