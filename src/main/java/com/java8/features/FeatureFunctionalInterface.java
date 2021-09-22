package com.java8.features;

import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FeatureFunctionalInterface {

	public static void main(String[] args) {
		// Custom functional Interface
		System.out.println("Custom functional interface Example");
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

		// Function
		System.out.println("Function Example");
		Function<Integer, String> function = x -> (x * 2) + "";
		System.out.println(function.apply(10)); // 20

		// Predicate
		System.out.println("Predicate Example");
		Predicate<String> predicate = x -> x.contains("java8");
		System.out.println(predicate.test("I love java8")); // true
		System.out.println(predicate.test("I love java9")); // false

		// Runnable
		System.out.println("Runnable Example");
		Runnable task = () -> {
			System.out.println("Running something here");
		};
		new Thread(task).start();

		// Bi-Consumer
		System.out.println("Bi-Consumer Example");
		BiConsumer<Integer, Integer> biConsumer = (x, y) -> {
			System.out.println("x into y is : " + x * y);
		};
		biConsumer.accept(5, 5); // 25
	}
}

@FunctionalInterface
interface Operationable {
	int calculate(int x, int y);
}
