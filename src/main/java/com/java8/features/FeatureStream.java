package com.java8.features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class FeatureStream {

	public static void main(String[] args) {
		FeatureStream streamTest = new FeatureStream();
		List<Employee> empList = streamTest.getEmpData();

		// get emp where lname is Patel
		System.out.println("where last name = patel");
		List<Employee> lnamePatelList = empList.stream().filter(e -> e.getLname().equalsIgnoreCase("Patel"))
				.collect(Collectors.toList());
		System.out.println(lnamePatelList);
		System.out.println();

		// get emp where salary is greater than 50000
		System.out.println("where salary is more than 50k");
		List<Employee> salaryMoreThan50KList = empList.stream().filter(e -> e.getSalary() > 50000)
				.collect(Collectors.toList());
		System.out.println(salaryMoreThan50KList);
		System.out.println();

		// sort emp by salary asc
		System.out.println("sort emp by salary asc");
		List<Employee> sortedBySalaryAsc = empList.stream().sorted(Comparator.comparingInt(Employee::getSalary))
				.collect(Collectors.toList());
		System.out.println(sortedBySalaryAsc);
		System.out.println();

		// sort emp by salary des
		System.out.println("sort emp by salary des");
		List<Employee> sortedBySalaryDes = empList.stream()
				.sorted(Comparator.comparingInt(Employee::getSalary).reversed()).collect(Collectors.toList());
		System.out.println(sortedBySalaryDes);
		System.out.println();

		// sort emp by firstName & then lastName
		System.out.println("sort emp by firstName & then lastName");
		List<Employee> sortedByFnameLname = empList.stream()
				.sorted(Comparator.comparing(Employee::getFname).thenComparing(Employee::getLname))
				.collect(Collectors.toList());
		System.out.println(sortedByFnameLname);
		System.out.println();

		// increase all emp salary by 20% and sort by salary
		System.out.println("increase all emp salary by 20%");
		List<Employee> increaseSalaryBy20Per = empList.stream().map(e -> {
			int newSalary = (int) (e.getSalary() + (e.getSalary() * 0.20));
			e.setSalary(newSalary);
			return e;
		}).sorted(Comparator.comparingInt(Employee::getSalary)).collect(Collectors.toList());
		System.out.println(increaseSalaryBy20Per);
		System.out.println();

		// group by Male & Female
		System.out.println("group by Male & Female");
		Map<Character, List<Employee>> groupByMap = empList.stream()
				.collect(Collectors.groupingBy(Employee::getGender));
		System.out.println(groupByMap);
		System.out.println();

		// convert into Map<Integer, Employee> :: <UserId, Employee>
		System.out.println("convert into Map<Integer, Employee> :: <UserId, Employee>");
		Map<Integer, Employee> empMap = empList.stream().collect(Collectors.toMap(c -> c.getUserId(), c -> c));
		System.out.println(empMap);
		System.out.println();

		// Emp groupBy City
		System.out.println("Emp groupBy City");
		Map<String, List<Employee>> empCityGroupByMap = empList.stream()
				.collect(Collectors.groupingBy(e -> String.valueOf(e.getAddress().getCity())));
		System.out.println(empCityGroupByMap);
		System.out.println();

		// Get Emp count groupBy City
		System.out.println("Emp count groupBy City");
		Map<String, Long> empCountGroupByCity = empList.stream()
				.collect(Collectors.groupingBy(e -> String.valueOf(e.getAddress().getCity()), Collectors.counting()));
		System.out.println(empCountGroupByCity);
		System.out.println();

		// Get salary total of all the employees
		System.out.println("Map Reduce : Get salary total of all the employees");
		int allEmpSalary = empList.stream().mapToInt(Employee::getSalary).reduce(0, (e1, e2) -> e1 + e2);
		System.out.println(allEmpSalary);
		System.out.println();

		// Get emp having minimum salary
		Optional<Employee> minSalaryEmpOpt = empList.stream().min(Comparator.comparing(Employee::getSalary));
		Employee minSalaryEmp = minSalaryEmpOpt.get();
		System.out.println("Min Salary Emp Name is :: " + minSalaryEmp.getFname() + " " + minSalaryEmp.getLname()
				+ " Min Salary is :: " + minSalaryEmp.getSalary());
		System.out.println();

		// Group by salary and sort it
		System.out.println("Group & sort by salary");
		Map<Integer, List<Employee>> empSalaryMap = empList.stream().collect(Collectors.groupingBy(Employee::getSalary))
				.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey,
						Map.Entry::getValue, (firstObject, conflictedObject) -> firstObject, LinkedHashMap::new));
		System.out.println(empSalaryMap);
		System.out.println();

		// FlatMap :: Get all the unique languages using flatMap
		System.out.println("FlatMap :: Get all the languages using flatMap");
		Set<String> knownLanguages = empList.stream().map(e -> e.getLanguagesKnown()).flatMap(l -> l.stream())
				.collect(Collectors.toSet());
		System.out.println(knownLanguages);
		System.out.println();

		// FlatMap :: Sort data without using stream
		System.out.println("Sort data without using Stream");
		List<Employee> freshEmpList = streamTest.getEmpData();
		freshEmpList.sort(Comparator.comparing(Employee::getSalary));
		System.out.println(freshEmpList);
		System.out.println();
	}

	public List<Employee> getEmpData() {
		List<Employee> employeeList = new ArrayList<>();

		// emp1
		Employee emp1 = new Employee();
		Address address1 = new Address();
		address1.setAddressLine1("Some Street1");
		address1.setAddressLine2("Some road1");
		address1.setArea("some area1");
		address1.setCity("Surat");
		address1.setCountry("India");
		address1.setPinCode(345678);
		emp1.setUserId(1000);
		emp1.setFname("Keval");
		emp1.setLname("Shah");
		emp1.setGender('M');
		emp1.setPhoneNumber(123456789);
		emp1.setAge(30);
		emp1.setSalary(50000);
		emp1.setAddress(address1);
		emp1.setLanguagesKnown(Arrays.asList("Hindi", "Gujarati", "English"));
		employeeList.add(emp1);

		// emp2
		Employee emp2 = new Employee();
		Address address2 = new Address();
		address2.setAddressLine1("Some Street2");
		address2.setAddressLine2("Some road2");
		address2.setArea("some area2");
		address2.setCity("Ahmedabad");
		address2.setCountry("India");
		address2.setPinCode(345678);
		emp2.setUserId(2000);
		emp2.setFname("Yash");
		emp2.setLname("Patel");
		emp2.setGender('M');
		emp2.setPhoneNumber(987654321);
		emp2.setAge(40);
		emp2.setSalary(30000);
		emp2.setAddress(address2);
		emp2.setLanguagesKnown(Arrays.asList("Hindi", "Gujarati", "English", "Urdu"));
		employeeList.add(emp2);

		// emp3
		Employee emp3 = new Employee();
		Address address3 = new Address();
		address3.setAddressLine1("Some Street3");
		address3.setAddressLine2("Some road3");
		address3.setArea("some area3");
		address3.setCity("Baroda");
		address3.setCountry("India");
		address3.setPinCode(123456);
		emp3.setUserId(3000);
		emp3.setFname("Meggie");
		emp3.setLname("Gandhi");
		emp3.setGender('F');
		emp3.setPhoneNumber(999555777);
		emp3.setAge(25);
		emp3.setSalary(60000);
		emp3.setAddress(address3);
		emp3.setLanguagesKnown(Arrays.asList("English"));
		employeeList.add(emp3);

		// emp4
		Employee emp4 = new Employee();
		Address address4 = new Address();
		address4.setAddressLine1("Some Street4");
		address4.setAddressLine2("Some road4");
		address4.setArea("some area4");
		address4.setCity("Rajkot");
		address4.setCountry("India");
		address4.setPinCode(123276);
		emp4.setUserId(4000);
		emp4.setFname("Krishna");
		emp4.setLname("Sharma");
		emp4.setGender('F');
		emp4.setPhoneNumber(999983777);
		emp4.setAge(27);
		emp4.setSalary(40000);
		emp4.setAddress(address4);
		emp4.setLanguagesKnown(Arrays.asList("Hindi", "Gujarati", "English", "French", "Punjabi"));
		employeeList.add(emp4);

		// emp5
		Employee emp5 = new Employee();
		Address address5 = new Address();
		address5.setAddressLine1("Some Street5");
		address5.setAddressLine2("Some road5");
		address5.setArea("some area5");
		address5.setCity("Rajkot");
		address5.setCountry("India");
		address5.setPinCode(123276);
		emp5.setUserId(5000);
		emp5.setFname("Jay");
		emp5.setLname("Patel");
		emp5.setGender('M');
		emp5.setPhoneNumber(923483777);
		emp5.setAge(27);
		emp5.setSalary(30000);
		emp5.setAddress(address5);
		emp5.setLanguagesKnown(
				Arrays.asList("Hindi", "Gujarati", "English", "French", "Punjabi", "Marathi", "Bangali"));
		employeeList.add(emp5);

		return employeeList;
	}
}

class Address {
	private String addressLine1;
	private String addressLine2;
	private String area;
	private String city;
	private String country;
	private int pinCode;

	@Override
	public String toString() {
		return "Address [addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", area=" + area + ", city="
				+ city + ", country=" + country + ", pinCode=" + pinCode + "]";
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
}

class Employee {

	private int userId;
	private String fname;
	private String lname;
	private int age;
	private char gender;
	private Address address;
	private int phoneNumber;
	private int salary;
	private List<String> languagesKnown;

	@Override
	public String toString() {
		return "Employee [userId=" + userId + ", fname=" + fname + ", lname=" + lname + ", age=" + age + ", gender="
				+ gender + ", address=" + address + ", phoneNumber=" + phoneNumber + ", salary=" + salary + "]";
	}

	public List<String> getLanguagesKnown() {
		return languagesKnown;
	}

	public void setLanguagesKnown(List<String> languagesKnown) {
		this.languagesKnown = languagesKnown;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
