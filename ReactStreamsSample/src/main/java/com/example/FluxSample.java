package com.example;

import org.assertj.core.util.Arrays;

import reactor.core.publisher.Flux;

public class FluxSample {
	public static void main(String[] args) {
		Flux<String> flux1 = Flux.just("aa", "bb");

		Flux<String> flux2 = Flux.fromArray(Arrays.array("aa", "bb"));
		
	
	}
}
