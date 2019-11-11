package meban;

//import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

class Employee{
	private int empId;
	private String empName,empAddress;
	
	
	public Employee(int empId, String empName, String empAddress) {
		this.empId = empId;
		this.empName = empName;
		this.empAddress = empAddress;
	}
	public int getEmpId() {
		return empId;
	}
	public String getEmpName() {
		return empName;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	
	
	
	public void setEmpId(int empId) { 
		this.empId = empId; 
	} 
	public void setEmpName(String empName) { 
		this.empName = empName; 
	} 
	public void setEmpAddress(String empAddress) { 
		this.empAddress = empAddress; 
	}
	
	public void setDetails(String empName,String empAddress) {
		//this.empId = empId;
		this.empName = empName;
		this.empAddress = empAddress;
	}
	 
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empAddress=" + empAddress + "]";
	}
	
}		

public interface EmpOps {
	void addNewEmployee(Employee newEmp);
	void deleteEmployee(Employee newEmp);
	Employee findEmployee(int id);
	void updateName(Employee emp);
	void updateAdd(Employee emp);
	void updateEmployee(Employee newEmp);
	void getAllEmployees();
}

class EmployeeRecords implements EmpOps{
	List<Employee> records;
	
	public EmployeeRecords() {
		records = new LinkedList<Employee>();
		//this.size = size;
	}

	@Override
	public void addNewEmployee(Employee newEmp) {
		records.add(newEmp);
	}

	@Override
	public void deleteEmployee(Employee newEmp) {
		ListIterator<Employee> iterator = records.listIterator();
		Employee dEmp;
		try {
			while(iterator.hasNext()) {
				if(iterator.next().getEmpId()== newEmp.getEmpId()) {
					/*
					 * dEmp=new
					 * Employee(iterator.next().getEmpId(),iterator.next().getEmpName(),iterator.
					 * next().getEmpAddress()); records.remove(dEmp);
					 */
					dEmp = iterator.previous();
					records.remove(dEmp);
					System.out.println("Delete Successful!");
				}
			}
		}catch (ClassCastException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	@Override
	public Employee findEmployee(int id) {
		ListIterator<Employee> iterator = records.listIterator();
		Employee objEmployee = null;
		//exception handling
		try {
		while(iterator.hasNext()) {
			if(iterator.next().getEmpId()==id) {
				//iterator.previous();
				objEmployee =iterator.previous();
				return objEmployee;
			}
		}
		}catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
			System.out.println("Error!");
		}
		return null;
	}
	@Override
	public void getAllEmployees() {
		if(records.isEmpty()) {
			System.out.println("Records Empty!");
			return;
		}
		for(Employee e:records)
		{
			System.out.println(e);
		}
	}
	
	@Override
	public void updateName(Employee emp) {
		ListIterator<Employee> iterator = records.listIterator();
		//System.out.println("This is first statement");
		try { 
			while(iterator.hasNext()) 
			{
				//System.out.println("This is True");
				if(iterator.next().getEmpName().equals(emp.getEmpName())) {
					//System.out.println("Inside if statement");
					MyConsole.getString("");
					iterator.previous().setEmpName(MyConsole.getString("Enter New Address:")); 
					iterator.next();
				}
			 } 
			  
		}catch (NoSuchElementException e) { 
			  System.out.println(e.getMessage()); 
		}
	}
	
	@Override
	public void updateAdd(Employee emp) {
		ListIterator<Employee> iterator = records.listIterator();
		try { 
			while(iterator.hasNext()) 
			{
				//System.out.println("This is True");
				if(iterator.next().getEmpAddress().equals(emp.getEmpAddress())) {
					//System.out.println("Inside if statement");
					MyConsole.getString("");
					iterator.previous().setEmpAddress(MyConsole.getString("Enter New Address:")); 
					iterator.next();
				}
			 } 
			  
		}catch (NoSuchElementException e) { 
			  //TODO: handle exception 
			  System.out.println(e.getMessage()); 
		}
	}
	
	@Override 
	 public void updateEmployee(Employee emp) {
		ListIterator<Employee> iterator = records.listIterator();
		try { 
			while(iterator.hasNext()) 
			{
				//System.out.println("This is True");
				if(iterator.next().getEmpId() == (emp.getEmpId())) {
					//System.out.println("Inside if statement");
					MyConsole.getString("");
					//iterator.previous().setEmpAddress(MyConsole.getString("Enter New Address:")); 
					iterator.previous().setDetails(MyConsole.getString("Enter New Name"), MyConsole.getString("Enter New Address"));
					iterator.next();
				}
			 } 
			  
		}catch (NoSuchElementException e) { 
			  //TODO: handle exception 
			  System.out.println(e.getMessage()); 
		}
	 }
}

