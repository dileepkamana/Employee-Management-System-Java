package EmployeeManagemtSystem;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, Employee> employees = new HashMap<>();

		FileService.loadEmployees(employees);
		
		while(true) {
			System.out.println("\n1. ADD Employees");
			System.out.println("2. VIEW Employees");
			System.out.println("3. SEARCH Employees");
			System.out.println("4. SEARCH by NAME");
			System.out.println("5. DELETE Employees");
			System.out.println("6. UPDATE Employees");
			System.out.println("7. SORT Employees");
			System.out.println("8. FILTER Employees");
			System.out.println("9. EXIT");
			
			int option = sc.nextInt();
			sc.nextLine();
			
			switch(option) {
				case 1:
					EmployeeService.addEmployees(employees, sc);
					FileService.saveEmployees(employees);
					break;
				case 2:
					EmployeeService.viewEmployees(employees);
					FileService.saveEmployees(employees);
					break;
				case 3:
					EmployeeService.searchEmployees(employees, sc);
//					FileService.saveEmployees(employees);
					break;
				case 4:
					EmployeeService.searchByName(employees, sc);
//					FileService.saveEmployees(employees);
					break;
				case 5:
					EmployeeService.deleteEmployees(employees, sc);
					FileService.saveEmployees(employees);
					break;
				case 6:
					EmployeeService.updateEmployees(employees, sc);
					FileService.saveEmployees(employees);
					break;
				case 7:
					EmployeeService.sortEmployees(employees, sc);
					break;
				case 8:
					EmployeeService.filterEmployees(employees, sc);
					break;
				case 9:
					FileService.saveEmployees(employees);
					System.out.println("\n----------EXIT-----------");
					System.out.println("\nThank You");
					return;
					
				default:
					System.out.println("Invalid......");
			}
		}
	}
}
