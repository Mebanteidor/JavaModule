package meban;

import java.util.Scanner;

public class EmployeeProject {
	private static Scanner scanner = new Scanner(System.in);
	static EmpOps empMgr = new EmployeeRecords();
	
	public static void main(String[] args) {
		processProgram();
	}
	private static void getMenu() {
		System.out.println("Employee Operations");
		System.out.println("Add Employee--->Press 1\n"
				+ "Delete Employee--->Press 2\n"
				+ "Update Employee--->Press 3\n"
				+ "Display Employee-->Press 4\n"
				+ "Find Employee----->Press 5\n"
				+ "Exit-------------->Press 6\n");
	}
	
	private static void processProgram() {
		boolean processing = true;
		do {
			getMenu();
			int choice = scanner.nextInt();
			processing = processMenu(choice);
		} while (processing);
	}
	private static boolean processMenu(int choice) {
		switch (choice) {
			case 1:
				add();
				//empMgr.addNewEmployee(newEmp);
				return true;
			case 2:
				delete();
				return true;
			case 3:
				update();
				return true;
			case 4:
				display();
				return true;
			case 5:
				find();
				return true;
			default:
				return false;
		}
	}
	
	private static boolean updateSelection(int choice,Employee emp) {
		switch (choice) {
			case 1:
				changeName(emp);
				return true;
			case 2:
				changeAdd(emp);
				return true;
			case 3:
				changeAll(emp);
				return true;
			default:
				return false;
		}
	}
	private static void add() { 
		Employee newEmp;
		String name = MyConsole.getString("Enter Employee name: ");
		String address = MyConsole.getString("Enter Employee address: ");
		int id = MyConsole.getNumber("Enter Employee Id: ");
		MyConsole.getString("");
		newEmp = new Employee(id,name,address);
		
		empMgr.addNewEmployee(newEmp);
	}

	private static void find() { 
		int id = MyConsole.getNumber("Enter ID of employee to find:");
		Employee obj =empMgr.findEmployee(id);
		System.out.println(obj);
	}
	private static void delete() { 
		//Employee newEmp;
		int id = MyConsole.getNumber("Enter ID of employee to delete:");
		Employee obj1 = empMgr.findEmployee(id);
		empMgr.deleteEmployee(obj1);
	}
	
	private static void updateMenu() {
		//implement exception handling here
		System.out.println("Updation Menu");
		System.out.println("Change name--->Press 1\n"
				+ "Change address--->Press 2\n"
				+ "Change all--->Press 3\n"
				+ "Exit Update Menu-->Press 4\n");
	}
	
	private static void update() {
		boolean quit = true;
		int id = MyConsole.getNumber("Enter ID of employee to update:");
		Employee empToUpdate = empMgr.findEmployee(id);
		do {
			updateMenu();
			int choice = MyConsole.getNumber("Enter Choice:");
			quit = updateSelection(choice,empToUpdate);
		} while (quit);
	}
	
	private static void changeName(Employee emp) {
		//Employee empToUpdate = empMgr.findEmployee(id);
		//emp.getEmpName();
		//System.out.println("changeName is called");
		empMgr.updateName(emp);
	}
	
	private static void changeAdd(Employee emp) {
		
		empMgr.updateAdd(emp);
	}
	
	private static void changeAll(Employee emp) {
		empMgr.updateEmployee(emp);
	}
	
	private static void display() {
		empMgr.getAllEmployees();
	}
}
