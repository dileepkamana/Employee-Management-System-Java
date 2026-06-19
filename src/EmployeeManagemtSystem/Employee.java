package EmployeeManagemtSystem;

public class Employee {
	private int id;
	private String name;
	private int salary;
	
	private static int nextId = 201;
	
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
}
