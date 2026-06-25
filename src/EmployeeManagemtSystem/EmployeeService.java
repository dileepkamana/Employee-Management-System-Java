package EmployeeManagemtSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EmployeeService {
//	------------------ADD----------------------
	public static void addEmployees(HashMap<Integer, Employee> employees, Scanner sc) {
		int choice = 1;
		while(choice == 1) {
			System.out.println("\nEnter Employee Name: ");
			String empName = sc.nextLine();
			System.out.println("Enter Employee Salary: ");
			int empSalary = sc.nextInt();
			
			if(empName.trim().isEmpty()) {
				System.out.println("\nName Cannot be Empty....");
			}
			else if(empSalary <= 1000) {
				System.out.println("Salary must be Greater than 1000");
			}
			else {
				Employee emp = new Employee(empName, empSalary);
				employees.put(emp.getId(), emp);
				System.out.println("\nEmployee "+ emp.getId()+" Added Successfully.....");
			}	
			
			System.out.println("\nAdd another Employee-----------");
			System.out.println("1. YES         2. NO");
			choice = sc.nextInt();
			sc.nextLine();
		}
		
	}
	
	
	// --------------VIEW--------------------------
		public static void viewEmployees(HashMap<Integer, Employee> employees) {
			if(employees.isEmpty()) {
				System.out.println("No Employee Found...");
			}
			else {
				System.out.println("\nEmployee Details");
				System.out.println("----------------");
				
				for(Employee e : employees.values()) {
					System.out.println(e);
				}
			}
		}
		
//		-----------------SEARCH-------------
		public static void searchEmployees(HashMap<Integer, Employee> employees, Scanner sc) {
			System.out.println("\nSearch Employee by Id: ");
			int searchId = sc.nextInt();
			
			Employee found = employees.get(searchId);
			
			if(employees.containsKey(searchId)) {
				System.out.println(found);
			}
			else {
				System.out.println("Employee not found");
			}
		}
		
//		-------------SEARCH by NAME-----------------
		public static void searchByName(HashMap<Integer, Employee> employees, Scanner sc) {
			System.out.println("\nSearch Employee by Name: ");
			String searchName = sc.nextLine();
			boolean found = false;
			for(Employee e : employees.values()) { //.contains() is a case-sensitive, that's why we use .toLowerCase() while checking two names
				if(e.getName().toLowerCase().contains(searchName.toLowerCase())) {
					System.out.println(e);
					found = true;
				}
			}
			if(!found) {
				System.out.println("Name not Found....");
			}
		}
//		----------------DELETE-----------------
		public static void deleteEmployees(HashMap<Integer, Employee> employees, Scanner sc) {
			System.out.println("\nDelete Employee by ID: ");
			int deleteId = sc.nextInt();
			
			if(employees.containsKey(deleteId)) {
				employees.remove(deleteId);
				System.out.println("Employee DELETED successfully.....");
			}
			else {
				System.out.println("Employee ID not found...");
			}
			
		}
//		--------------UPDATE----------------------
		public static void updateEmployees(HashMap<Integer, Employee> employees, Scanner sc) {
			System.out.println("\nUPDATE Employee by ID: ");
			int updateId = sc.nextInt();
			
			Employee found = employees.get(updateId);
			
			if(found != null) {
				System.out.println("Current Details: "+ found);
				System.out.println("\nEnter new Salary: ");
				int updateSalary = sc.nextInt();
				
				if(updateSalary > 1000) {
					found.setSalary(updateSalary);
					System.out.println("\nSalary Updated Successfully..");
					System.out.println("New salary is: "+ found.getSalary());
				}else {
					System.out.println("Salary should greater than 1000");
				}
				
			}
			else {
				System.out.println("ID Not Found");
			}
		}
//		---------SORT by salary----------
/*
Why convert HashMap values into ArrayList before sorting?
HashMap is an unordered collection and does not support sorting. 
Therefore, I extract the values into an ArrayList and then sort the list using a Comparator.
--------
here, We need to tell Java: How do I compare two employees?
Example:Dileep = 69000, Ravi   = 99000
To sort, Java must decide: Which one comes first?
That comparison logic is called a: Comparator
*/
		public static void sortBySalary(HashMap<Integer, Employee> employees) {
			ArrayList<Employee> list = new ArrayList<>(employees.values());
		}
}
