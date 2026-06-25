package EmployeeManagemtSystem;

public class Employee {
	private int id;
	private String name;
	private int salary;
	
	private static int nextId = 201;
	
	//new employee
	public Employee(String name, int salary){
		this.name= name;
		this.salary = salary;
		
		this.id = nextId;
		nextId++;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Id: "+id +" | Name: "+name +" | Salary: "+salary;
	}
	
	//constructor overloading
	//to load existing employee, coz, normally when loading everytime it takes new id, to secure this problem, this method comes to an action
	public Employee(int id, String name, int salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	//setter
	public static void setNextId(int nextId) {
		Employee.nextId = nextId;  //why it is static method & Employee.next... & why not this.nextId ? coz, its a static variable
	}
	//getter nextId
	public int getNextId() {
		return nextId;
	}
}
