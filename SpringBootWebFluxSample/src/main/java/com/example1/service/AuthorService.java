package com.example1.service;

import java.time.Duration;
import java.util.Comparator;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example1.dto.Author;
import com.example1.dto.AuthorMessage;
import com.example1.dto.AuthorMessageResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

@Service
public class AuthorService {

	private static Comparator<String> nullSafeStringComparator = Comparator
	        .nullsFirst(String::compareToIgnoreCase); 

	
	/**
	 * Mono is for either fire and forget or request-response 
	 * @param id
	 * @return
	 */
	public Mono<Author> loadUserFromComplexSystem(String id){
		Author author = new Author();
		author.setId(id);
		author.setName("Test");
		author.setThumbnail("http://thumbnail.org/");
		Duration delay = Duration.ofMillis(10000);
		return Mono.justOrEmpty(author).delaySubscription(delay);
	}
	
	/**
	 * Flux is for streams 
	 * @param message
	 * @return
	 */
	public Flux<AuthorMessageResponse> sendMessageToAuthor(@RequestBody AuthorMessage message) {
        return Flux.just(message)
                .map(msg -> {
                	Tuple2<AuthorMessage, String> tuple  = Tuples.of(msg, msg.getMessage());
                	return tuple;
                })
                .flatMap(tup -> {
                	tup.forEach(item -> System.out.println(item));
                    if (nullSafeStringComparator.compare(tup.getT2(), "") == 0) {
                        return Flux.error(new RuntimeException("Throwing a deliberate Exception!"));
                    }
                    AuthorMessage msg = tup.getT1();
                    return Flux.just(new AuthorMessageResponse(msg.getAuthorId(),"Success " ));
                });
    }

}
