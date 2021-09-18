package com.java8.features;

import java.util.function.Consumer;

public class Java8FeaturesApplication {

	public static void main(String[] args) {
		Operationable addition = (x,y) -> x + y;
		int result1 = addition.calculate(10, 5);
		System.out.println(result1); // 15

		Operationable multiplication = (x,y) -> x * y;
		int result2 = multiplication.calculate(10, 5);
		System.out.println(result2); // 50
		
		// Consumer
		Consumer<Integer> consumerOfInteger = (x) -> System.out.println(x*2);
		consumerOfInteger.accept(5); // 10
	}
}

@FunctionalInterface
interface Operationable {
	int calculate (int x, int y);
}
