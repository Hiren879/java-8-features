package com.java8.features;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Java8FeaturesApplication {

	public static void main(String[] args) {
		Operationable addition = (x, y) -> x + y;
		int result1 = addition.calculate(10, 5);
		System.out.println(result1); // 15

		Operationable multiplication = (x, y) -> x * y;
		int result2 = multiplication.calculate(10, 5);
		System.out.println(result2); // 50

		// Consumer
		System.out.println("Consumer Example");
		Consumer<Integer> consumerOfInteger = (x) -> System.out.println(x * 2);
		consumerOfInteger.accept(5); // 10

		// Supplier
		System.out.println("Supplier Example");
		Supplier<Integer> supplierOfInteger = () -> new Random().ints(0, 50).findFirst().getAsInt();
		System.out.println(supplierOfInteger.get());
	}
}

@FunctionalInterface
interface Operationable {
	int calculate(int x, int y);
}
