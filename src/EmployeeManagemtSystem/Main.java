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
					EmployeeService.addEmployees(employees, sc);
					break;
				case 2:
					EmployeeService.viewEmployees(employees);
					break;
				case 3:
					EmployeeService.searchEmployees(employees, sc);
					break;
				case 4:
					EmployeeService.deleteEmployees(employees, sc);
					break;
				case 5:
					EmployeeService.updateEmployees(employees, sc);
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
}
