import java.util.Scanner;

public class InputName {

	public static void main(String[] args) {
		//Scanner class from Core Java can be used for taking user input
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter your name");
		//declaring and initializing a variable
		String name = s.nextLine();
		
		System.out.println("Hello " + name.toUpperCase());
	}
}
