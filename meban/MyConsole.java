package meban;


import java.util.Scanner;

public class MyConsole {
	private static Scanner sn = new Scanner(System.in);
	static void print(Object data) {
		System.out.println(data);
	}
	
	static String getString(String question) {
		print(question);
		return sn.nextLine();
	}
	
	static double getDouble(String question) {
		print(question);
		return sn.nextDouble();
	}
	
	static int getNumber(String question) {
		print(question);
		return sn.nextInt();
	}
}
