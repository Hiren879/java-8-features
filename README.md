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

## **Optional**
1. A container object which may or may not contain a non-null value.
2. if value if present -> true
3. if not -> false
4. get() will provide the actual value.

```
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
```

## **Streams**
### What is Stream ?
- Pipeline of aggregate operations

### Characteristics of a Stream
- **Declarative**: stream tells what has to be done but not how.
- **Lazy**: if you won't call terminal operation, our stream won't be doing anything.
- **Only Once**: You can consume it only once.
- **Parallelized**: by default stream is sequential but you can make it to run parallel. 

### Life cycle of a stream
1. Split - data is collected from a collection and converted into a stream
2. Apply - apply function to each element of a stream
3. Combine - complete the stream using a terminal operation

Split phase contains two important operations which can be achieved via **Spliterator** interface.

**Spliterator**: **iterating and the potential splitting of elements**

Examples:
1. Get emp where lname is Patel
```
List<Employee> lnamePatelList = 
		empList.stream()
			.filter(e -> e.getLname().equalsIgnoreCase("Patel"))
			.collect(Collectors.toList());
```

2. Get emp where salary is greater than 50000
```
List<Employee> salaryMoreThan50KList = 
		empList.stream()
			.filter(e -> e.getSalary() > 50000)
			.collect(Collectors.toList());
```

3. Sort emp by salary asc
```
List<Employee> sortedBySalaryAsc = 
		empList.stream()
			.sorted(Comparator.comparingInt(Employee::getSalary))
			.collect(Collectors.toList());
```

4. Sort emp by salary des
```
List<Employee> sortedBySalaryDes = 
		empList.stream()
			.sorted(Comparator.comparingInt(Employee::getSalary).reversed())
			.collect(Collectors.toList());
```

5. Sort emp by firstName & then lastName
```
List<Employee> sortedByFnameLname = 
		empList.stream()
			.sorted(Comparator.comparing(Employee::getFname).thenComparing(Employee::getLname))
			.collect(Collectors.toList());
```

6. Increase all emp salary by 20% and sort by salary
```
List<Employee> increaseSalaryBy20Per = 
		empList.stream()
		.map(e -> {
			int newSalary = (int) (e.getSalary() + (e.getSalary() * 0.20));
			e.setSalary(newSalary);
			return e;
		 })
		.sorted(Comparator.comparingInt(Employee::getSalary))
		.collect(Collectors.toList());
```

7. Group emp by Male & Female
```
Map<Character, List<Employee>> groupByMap = 
		empList.stream()
			.collect(Collectors.groupingBy(Employee::getGender));
```

8. Convert list into Map<Integer, Employee> :: <UserId, Employee>
```
Map<Integer, Employee> empMap = 
		empList.stream()
			.collect(Collectors.toMap(c -> c.getUserId(), c -> c));
```

9. Emp groupBy City
```
Map<String, List<Employee>> empCityGroupByMap = 
		empList.stream()
			.collect(Collectors.groupingBy(e -> String.valueOf(e.getAddress().getCity())));
``` 

10. Get Emp count groupBy City
```
Map<String, Long> empCountGroupByCity = 
		empList.stream()
			.collect(Collectors.groupingBy(e -> String.valueOf(e.getAddress().getCity()), Collectors.counting()));
```
