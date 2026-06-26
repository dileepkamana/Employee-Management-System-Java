package EmployeeManagemtSystem;

import java.util.ArrayList;
import java.util.Comparator;
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

Comparator ? --> it is used to compare the two objects
in below method, we passed a comparator object as a parameter
*/
		
		public static void printSortedEmployees(HashMap<Integer, Employee> employees, Comparator<Employee> comparator) {
			ArrayList<Employee> list = new ArrayList<>(employees.values());
			list.sort(comparator);
			
			for(Employee e : list) {
				System.out.println(e);
			}
		}
		
//		---------------SORTING-------------------
		public static void sortEmployees(HashMap<Integer, Employee> employees, Scanner sc) {
			while(true) {
				System.out.println("\n1. Salary (High → Low)");
				System.out.println("2. Salary (Low → High)");
				System.out.println("3. Name (A → Z)");
				System.out.println("4. Name (Z → A)");
				System.out.println("5. Back");
				
				System.out.println("\nSelect Option:--------------------");
				int option = sc.nextInt();
				switch(option) {
				case 1:
					printSortedEmployees(employees, (e1, e2) -> Integer.compare(e2.getSalary(), e1.getSalary()));
					break;
				case 2:
					printSortedEmployees(employees, (e1, e2) -> Integer.compare(e1.getSalary(), e2.getSalary()));
					break;
				case 3:
					printSortedEmployees(employees, (e1, e2) -> (e1.getName().compareToIgnoreCase(e2.getName())));
					break;
				case 4:
					printSortedEmployees(employees, (e1, e2) -> (e2.getName().compareToIgnoreCase(e1.getName())));
					break;
				case 5:
					System.out.println("\n-----Exit from SORTING-----");
					return;
				default:
						System.out.println("Invalid Option");
				}
			}
			
		}
		
//		----------------------FILTERING------------------------
		public static void filterEmployees(HashMap<Integer, Employee> employees, Scanner sc) {
			while(true) {
				System.out.println("\n1. Salary Above");
				System.out.println("2. Salary Below");
				System.out.println("3. Salary Between");
				System.out.println("4. Name Starts With");
				System.out.println("5. Back");
				
				System.out.println("Enter Option: -------");
				int option = sc.nextInt();
				
				switch(option) {
				case 1:
					filterBySalaryAbove(employees, sc);
					break;
					
				case 2:
					filterBySalaryBelow(employees, sc);
					break;
					
				case 3:
					filterBySalaryBetween(employees, sc);
					break;
					
				case 4:
					filterByNameStartsWith(employees, sc);
					break;
					
				case 5:
					System.out.println("\n-----Exit from SORTING-----");
					return;
				default:
						System.out.println("Invalid Option");
				}
			}
		}
		
		public static void filterBySalaryAbove(HashMap<Integer, Employee> employees, Scanner sc) {
			System.out.println("Enter Minimum Salary: ----");
			int minSalary = sc.nextInt();
			boolean found = false;
			
			for(Employee e : employees.values()) {
				if(e.getSalary() >= minSalary) {
					System.out.println(e);
					found = true;
				}
			}
			if(!found) {
				System.out.println("No Employee found with salary above ₹"+minSalary);
			}
		}
		
		public static void filterBySalaryBelow(HashMap<Integer, Employee> employees, Scanner sc) {
			System.out.println("Enter Maximum Salary: ----");
			int maxSalary = sc.nextInt();
			boolean found = false;
			
			for(Employee e : employees.values()) {
				if(e.getSalary() <= maxSalary) {
					System.out.println(e);
					found = true;
				}
			}
			if(!found) {
				System.out.println("No Employee found with salary below ₹"+maxSalary);
			}
		}
		
		public static void filterBySalaryBetween(HashMap<Integer, Employee> employees, Scanner sc) {
			System.out.println("Enter Minimum Salary: -----");
			int minSalary = sc.nextInt();
			System.out.println("Enter Maximum Salary: ----");
			int maxSalary = sc.nextInt();
			
			boolean found = false;
			
			if(minSalary > maxSalary) {
			    System.out.println("Minimum salary cannot be greater than maximum salary.");
			    return;
			}
			
			for(Employee e : employees.values()) {
				if((minSalary <= e.getSalary()) && (e.getSalary() <= maxSalary)) {
					System.out.println(e);
					found = true;
				}
			}
			if(!found) {
				System.out.println("No Employee found in between ₹" +minSalary+" salary and ₹"+maxSalary +"salary");
			}
		}
		
		public static void filterByNameStartsWith(HashMap<Integer, Employee> employees, Scanner sc) {
			System.out.println("Enter Starting Letters:---------");
			String searchName = sc.next();
			boolean found = false;
			
			for(Employee e : employees.values()) {
				if(e.getName().toLowerCase().startsWith(searchName)) {
					System.out.println(e);
					found = true;
				}
			}
			if(!found) {
				System.out.println("No Employee found with starting Letters: "+searchName);
			}
		}
}
