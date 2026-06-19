package EmployeeManagemtSystem;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, Employee> employees = new HashMap<>();
		
		while(true) {
			System.out.println("\n1. ADD Employees");
			System.out.println("2. VIEW Employees");
			System.out.println("3. SEARCH Employees");
			System.out.println("4. DELETE Employees");
			System.out.println("5. UPDATE Employees");
			System.out.println("6. EXIT");
			
			int option = sc.nextInt();
			sc.nextLine();
			
			switch(option) {
				case 1:
					addEmployees(employees, sc);
					break;
				case 2:
					viewEmployees(employees);
					break;
				case 3:
					searchEmployees(employees, sc);
					break;
				case 4:
					deleteEmployees(employees, sc);
					break;
				case 5:
					updateEmployees(employees, sc);
					break;
				case 6:
					System.out.println("\n----------EXIT-----------");
					System.out.println("\nThank You");
					return;
					
				default:
					System.out.println("Invalid......");
			}
		}
	}
	
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
	
//	-----------------SEARCH-------------
	public static void searchEmployees(HashMap<Integer, Employee> employees, Scanner sc) {
		System.out.println("\nSearch Employee by Id: ");
		int searchId = sc.nextInt();
		
		Employee found = employees.get(searchId);
		
		if(employees.containsKey(searchId)) {
			System.out.println("Employee not found");
		}
		else {
			System.out.println(found);
		}
	}
	
//	----------------DELETE-----------------
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
//	--------------UPDATE----------------------
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
}
