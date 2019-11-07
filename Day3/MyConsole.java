package basics;
import java.util.Scanner;

public class MyConsole {
	private static Scanner sn = new Scanner(System.in);
	public static void print(Object obj) {
		System.out.println(obj);
	}
	
	public static String getString(String question) {
		print(question);
		return sn.nextLine();
	}
	
	public static int getNumber(String question) {
		return Integer.parseInt(getString(question));
	}
	
	public static double getDouble(String question) {
		print(question);
		return sn.nextDouble();
	}
}
