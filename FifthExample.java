
//FifthExample.java:ExpenseManager...
import java.util.*;

//import java.time.*;//for date and time...
class Expense {
	private int id;
	private double amount;
	private String details;
	private Date date;

	// What is function?
	Expense(int id, double amount, Date date, String info) {
		this.id = id;
		this.amount = amount;
		this.date = date;
		this.details = info;
	}

	public int getId() {
		return this.id;
	}

	public double getAmount() {
		return this.amount;
	}

	public Date getDate() {
		return this.date;
	}

	public String getdetails() {
		return this.details;
	}

	public String toString() {
		return "Details: " + details + "\nAmount: " + amount + "\nExpenseID: " + id + "\nDate: " + date;
	}
	// todo: create get Accessors to all the fields....
}

////////////////// Manager class////////////////////////////
class ExpenseManager {
	protected Expense[] _allExpenses;
	int size = 0;
	static int index = 0;

	ExpenseManager(int size) {
		_allExpenses = new Expense[size];
		this.size = size;
	}

	public void addNewExpense(Expense ex) {
		if (index > size) {
			for (int i = 0; i < _allExpenses.length; i++) {
				if (_allExpenses[i].equals(null)) {
					_allExpenses[i] = ex;
					return;
				}
			}
		} else {
			_allExpenses[index] = ex;
			index++;
		}
	}

	public void updateExpense(Expense ex) {
		for (int i = 0; i < _allExpenses.length; i++) {
			if (_allExpenses[i].getId() == ex.getId()) {
				_allExpenses[i] = ex;
				System.out.println("Update Successful!");
				return;
			}
		}
	}

	public void deleteExpense(int id) {
		// int deleteIndex;
		for (int i = 0; i < _allExpenses.length; i++) {
			if (_allExpenses[i].getId() == id) {
				_allExpenses[i] = null;
				return;
			}
		}
	}

	public void findExpense(String detail) {
		if (detail.isEmpty()) {
			return;
		}
		for (Expense i : _allExpenses) {
			if (i.getdetails().contains(detail)) {
				System.out.println(i);
			}
		}
	}

	public void displayAll() {
		for (Expense i : _allExpenses) {
			if (i.equals(null))
				continue;
			else
				System.out.println(i);
		}
	}
}

////////////////////////// Utility Class///////////////////

class ExpenseFactory {
	public static ExpenseManager expenseManager(String type) {
		if (type.equals("Array")) {// Use equals for comparing reference types....
			int size = MyConsole.getNumber("Enter the no of Expenses to hold");
			return new ExpenseManager(size);
		}
		return null;// No memory is allocated....
	}
}

///////////////// UI Class///////////////////////////////
class FifthExample {
	static ExpenseManager _mgr = ExpenseFactory.expenseManager("Array");

	public static void main(String[] args) {
		if (_mgr == null) {
			MyConsole.print("OOPS! Something wrong happened!!!\n");
			return;
		}
		processProgram();
	}

	private static void processProgram() {
		boolean processing = true;
		do {
			String menu = getMenu();
			int choice = MyConsole.getNumber(menu);
			processing = processMenu(choice);
		} while (processing);
	}

	private static String getMenu() {
		String menu = "~~~~~~EXPENSE MANAGER SOFTWARE~~~~~~~~\n";
		menu += "TO ADD NEW EXPENSE------------->PRESS 1\n";
		menu += "TO DELETE AN EXPENSE----------->PRESS 2\n";
		menu += "TO FIND EXPENSES--------------->PRESS 3\n";
		menu += "TO UPDATE EXPENSE--------------->PRESS 4\n";
		menu += "TO DISPLAY ALL EXPENSES--------------->PRESS 5\n";
		menu += "NOTE: ANY OTHER KEY IS CONSIDERED AS EXIT";
		return menu;
	}

	private static boolean processMenu(int choice) {
		switch (choice) {
		case 1:
			addingExpense();
			break;
		case 2:
			deletion();
			break;
		case 3:
			findingExpense();
			break;
		case 4:
			update();
			break;
		case 5:
			display();
			break;
		default:
			return false;
		}
		return true;
	}

	private static void display() {
		//int id = MyConsole.getNumber("Enter the id of the expense to delete: ");
		try {
			_mgr.displayAll();
		} catch (Exception ex) {
			MyConsole.print(ex.getMessage());
		}
	}

	private static void update() {
		int id = MyConsole.getNumber("Enter the id of the expense to update: ");
		try {
			// _mgr.updateExpense(id);
			// int id = MyConsole.getNumber("Enter the ID of the Expense");
			String detail = MyConsole.getString("Enter New Expense Details in brief");
			double amount = MyConsole.getDouble("Enter New Amount spent on that Expense");
			int dd = MyConsole.getNumber("Enter the day");
			int mm = MyConsole.getNumber("Enter the month");
			int yy = MyConsole.getNumber("Enter the year");
			Date dt = new Date(yy, mm, dd);
			Expense ex = new Expense(id, amount, dt, detail);
			_mgr.updateExpense(ex);
		} catch (Exception ex) {
			MyConsole.print(ex.getMessage());
		}
	}

	private static void deletion() {
		int id = MyConsole.getNumber("Enter the id of the expense to delete: ");
		try {
			_mgr.deleteExpense(id);
		} catch (Exception ex) {
			MyConsole.print(ex.getMessage());
		}
	}

	private static void findingExpense() {
		String detail = MyConsole.getString("Enter the detail or part of the detail to find the expenses");
		try {
			_mgr.findExpense(detail);
		} catch (Exception ex) {
			MyConsole.print(ex.getMessage());
		}
	}

	private static void addingExpense() {
		try {
			int id = MyConsole.getNumber("Enter the ID of the Expense");
			String detail = MyConsole.getString("Enter the Expense Details in brief");
			double amount = MyConsole.getDouble("Enter the Amount spent on that Expense");
			int dd = MyConsole.getNumber("Enter the day");
			int mm = MyConsole.getNumber("Enter the month");
			int yy = MyConsole.getNumber("Enter the year");
			Date dt = new Date(yy, mm, dd);
			Expense ex = new Expense(id, amount, dt, detail);
			_mgr.addNewExpense(ex);
			MyConsole.print("Expense added Successfully");
		} catch (Exception ex) {
			MyConsole.print(ex.getMessage());
		}
	}
}