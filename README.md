# Java 8 features
This repository is developed to understand most commonly used java 8 futures.

## **Lambda Expressions**
1. The **interface** having just one abstract method is known as functional interface.
2. We can define functional interface with the annotation @functionalInterface
3. Lambda expression provides implementation of such functional interface having only one abstract method.
4. The basic syntax of Lambda expression is **(argument) → (body)**
5. A functional interface can have any number of default methods.

```
@FunctionalInterface // 1
interface Operationable {
	int calculate (int x, int y); // 2
}

public class Java8FeaturesApplication {

	public static void main(String[] args) {
		Operationable addition = (x,y) -> x + y; // 3
		int result1 = addition.calculate(10, 5); // 4
		System.out.println(result1);

		Operationable multiplication = (x,y) -> x * y;
		int result2 = multiplication.calculate(10, 5);
		System.out.println(result2);
	}
}
```

