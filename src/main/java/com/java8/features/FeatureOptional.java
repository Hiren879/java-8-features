package com.java8.features;

import java.util.Optional;

public class FeatureOptional {

	public static void main(String[] args) {
		Optional<Integer> optInteger = Optional.of(10);
		// ifPresent
		optInteger.ifPresent(x -> System.out.println(x * 2));
		// get()
		Integer intValue = optInteger.get();
		System.out.println(intValue);
		// In case of NULL or EMPTY it will throw an exception
		// optInteger = null;
		optInteger = Optional.empty();
		optInteger.orElseThrow(RuntimeException::new);
	}

}
