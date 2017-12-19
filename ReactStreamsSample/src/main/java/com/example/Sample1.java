package com.example;

import java.util.Arrays;
import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Sample1 {
	public static void main(String[] args) {

		List<String> words = Arrays.asList("the", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog");

		Flux<String> fewWords = Flux.just("Hello", "World");
		Flux<String> manyWords = Flux.fromIterable(words);

		fewWords.subscribe(System.out::println);
		System.out.println();
		manyWords.subscribe(System.out::println);
		
		Mono<String> moreOnce =Mono.just("moreOnce");
		moreOnce.subscribe(System.out::println);
		
		System.out.println(">>>>>>");
		
		 Flux<String> manyLetters = Flux
			        .fromIterable(words)
			        .flatMap(word -> Flux.fromArray(word.split("")))
			        .distinct()
			        .sort()
			        .zipWith(Flux.range(1, Integer.MAX_VALUE),
			              (string, count) -> String.format("%2d. %s", count, string));

			  manyLetters.subscribe(System.out::println);
			  
			  System.out.println("<<<<<<<<<<<<<");
			  Mono<String> missing = Mono.just("s");
			  Flux<String> allLetters = Flux
			        .fromIterable(words)
			        .flatMap(word -> Flux.fromArray(word.split("")))
			        .concatWith(missing)
			        .distinct()
			        .sort()
			        .zipWith(Flux.range(1, Integer.MAX_VALUE),
			              (string, count) -> String.format("%2d. %s", count, string));

			  allLetters.subscribe(System.out::println);
	}
}
