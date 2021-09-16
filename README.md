# Java 8 features
This repository is developed to understand most commonly used java 8 futures.

## **Lambda Expressions**
1. The **interface** having just one abstract method is known as functional interface.
2. We can define functional interface with the annotation @functionalInterface
3. Lambda expression provides implementation of such functional interface having only one abstract method.
4. The basic syntax of Lambda expression is **(argument) → (body)**
5. A functional interface can have any number of default methods.

```
@FunctionalInterface // ------------------------> 1
interface Operationable {
	int calculate (int x, int y); // -------------> 2
}

public class Java8FeaturesApplication {

	public static void main(String[] args) {
		Operationable addition = (x,y) -> x + y; //------------> 3
		int result1 = addition.calculate(10, 5); // ------------> 4
		System.out.println(result1);

		Operationable multiplication = (x,y) -> x * y;
		int result2 = multiplication.calculate(10, 5);
		System.out.println(result2);
	}
}
```
1. Even if you do not write annotation, Java will consider this interface as functional interface because it has only one method.
2. Provide the signature of your abstract method.
3. The most important part : **This is the place where we will actually provide business logic that we want to perform using signature that we have provided in interface.** Here we are saying that we want to perform addition.
4. Here we will actually call the method and pass the arguments to execute the business logic.
