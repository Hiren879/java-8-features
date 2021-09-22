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

## **Types of functional Interface**
### Consumer :
1. It only consumes the data & performs the operation on it
2. Does not return anything

Example:
```
// Consumer
Consumer<Integer> consumerOfInteger = (x) -> System.out.println(x*2); // ----->1
consumerOfInteger.accept(5); // 10 ---->2
```
In above code we are saying that
1. Define a consumer which consumes the argument "x", multiply it with 2 and then print it.
2.  User the consumer and call the **accept** method with the actual Integer value. 

### Supplier (Producer):
1. It does not take any input.
2. But it will supply/produce something.

Example:
```
Supplier<Integer> supplierOfInteger = () -> new Random()
	.ints(0, 50) // get random number from the range o to 50
	.findFirst() // get the stream and findFirst
	.getAsInt(); // return it as an Integer
	
System.out.println(supplierOfInteger.get()); // call the get() on supplier
```

### Function:
1. It will take something as an input.
2. And it will return something as an output.

Example:
```
Function<Integer, String> function = x -> (x * 2) + "";
System.out.println(function.apply(10)); // 20
```
In above example, we are accepting **Integer** and returning **String** value after doing multiplication with 2.

### Predicate:
1. Takes the input.
2. Returns the boolean (true/false).

Example:
```
Predicate<String> predicate = x -> x.contains("java8");
System.out.println(predicate.test("I love java8")); // true
System.out.println(predicate.test("I love java9")); // false
```
In, above example we are checking if string contains "java8" in it or not.

### Runnable:
1. Neither take anything nor produce anything.
2. Just perform some task on thread.

Example:
```
Runnable task = () -> {System.out.println("Running something here");};
new Thread(task).start();
```

### Bi-Consumer:
1. Takes two input. May be of same type, may be not of the same type.
2. Does not produce/return anything.

Example:
```
BiConsumer<Integer, Integer> biConsumer = (x, y) -> {
	System.out.println("x into y is : " + x * y);};
biConsumer.accept(5, 5); // 25
```

## **Default Interface Method**
1. Interface having methods with the method body is called default interface method.
2. Class implementing such interface need not to always implement such method.
3. In case of diamond problem, class needs to provide its own implementation for all such methods.
4. Same needs to be done in case of one interface has default method and other has abstract method.

