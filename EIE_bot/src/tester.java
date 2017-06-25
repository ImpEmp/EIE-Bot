import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class tester {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		hostile_detect d = new hostile_detect ();
		
		System.out.print("enter in the test>>>");
		Scanner scanner = new Scanner(System.in);
		String test = scanner.nextLine();
		System.out.print(d.filterText(test));
	}

}
