package EmployeeManagemtSystem;
/*
 * FileService responsibility: Read File & Write File Only.
	Not:Store Employees, Manage Employees
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;


public class FileService {
	public static void saveFile() {
		try {
			FileWriter fw = new FileWriter("Employee.txt");
			fw.write("Hello....Employee Management System........");
			fw.close();
			
			System.out.println("File Written Successfully.....");
		} 
		catch (IOException e) {
			
			System.out.println("Error: "+e.getMessage());
		}
	}
// ---- write the data into the text file-------------------------
	/*  ---- "Serialization"-------
When program exits: HashMap --> Destroyed
RAM is temporary.
So we convert objects into text and store them in a file.
This process is called: "Serialization (simplified form)"
	 */
	public static void saveEmployees(HashMap<Integer, Employee> employees) {
		try {
			FileWriter fw = new FileWriter("Employee.txt");
			
			for(Employee e : employees.values()) { // why to store data in commas ? Because file can store:TEXT, not Java objects directly.
				String data = e.getId()+","+ e.getName()+","+e.getSalary();
				
				fw.write(data + "\n");
			}
			fw.close();
		}
		catch(IOException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	
//-------------
	public static void loadEmployees(HashMap<Integer, Employee> employees) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("Employee.txt"));
			String line = br.readLine();
			int highestId = 0;
			while(line != null) {
//				System.out.println(line);
				String[] parts = line.split(",");
				int id = Integer.parseInt(parts[0]);
				String name = parts[1];
				int salary = Integer.parseInt(parts[2]);
				
				Employee emp = new Employee(id, name, salary);
				employees.put(id, emp);
				
				if(id > highestId) {
					highestId = id;
				}
				
				line = br.readLine();
			}
			Employee.setNextId(highestId+1);
			System.out.println(employees.size()+" : Employees Loaded");
			br.close();
		}
		catch(IOException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
}
