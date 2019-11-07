package basics;//This tells that the class is a part of a grouping called basics. 

import java.util.Scanner;

enum AccountType{
	SB, RD, FD
}
abstract class Account{
	int accNo;
	String accHolder;
	double balance;
	void credit(double amount) {
		balance += amount;
	}
	
	void debit(double amount) throws Exception {
		if(amount > balance)
			throw new Exception("Insuffient funds");
		balance -= amount;
	}
	
	abstract void calculateInterest();
}

class SBAccount extends Account{
	@Override
	void calculateInterest() {
		double interest = this.balance * 1/12 * 6.5/100;
		credit(interest);
	}	
}

class RDAccount extends Account{
	@Override
	void calculateInterest() {
		double interest = this.balance * 1/4 * 8.5/100;
		credit(interest);
	}
}
class FDAccount extends Account{
	@Override
	void calculateInterest() {
		double interest = this.balance * 12.5/100;
		credit(interest);
	}
}

class AccountFactory{
	public static Account createAccount(AccountType acc) {
		Account account = null;
		switch (acc) {
		case FD:
			account = new FDAccount();
			break;
		case RD:
			account = new RDAccount();
			break;
		default:
			account = new SBAccount();
			break;
		}
		return account;
	}
}
public class AbstractDemo {

	private static void printAccountTypes() {
		MyConsole.print("Select the type of account from the List below");
		AccountType [] types = AccountType.values();
		for(AccountType t : types) {
			MyConsole.print(t);
		}
	}
	
	private static AccountType createType() {
		Scanner sn = new Scanner(System.in);
		String value = sn.next();
		AccountType type = AccountType.valueOf(value);
		return type;
	}
	public static void main(String[] args) {
		printAccountTypes();
		AccountType type = createType();
		Account acc = AccountFactory.createAccount(type);
		acc.credit(6000);
		acc.accHolder="Phaniraj";
		acc.accNo = 2344;
		acc.calculateInterest();
		MyConsole.print("The current balance is " + acc.balance);
	}
}

















