import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class hostile_detect {
public Boolean twitterban(String text){
	
	return null;
	
}
public Boolean is_tagged(String text){
	
	return null;
	
}
public int Cursewords(String s){
int y = 0;
	 String[] arr = s.split(" ");    

	 for (String ss : arr) {
		 File file = new File("bad.txt");

		 try {
		     @SuppressWarnings("resource")
			Scanner scanner = new Scanner(file);

		     //now read the file line by line...

		     while (scanner.hasNextLine()) {
		         String line = scanner.nextLine();
		         if(ss==line) { 
		           y++;  
		         }
		     }
		 } catch(FileNotFoundException e) { 
		     //handle this
		 }
	  }

	return y;
	
}
public Boolean facebookban(String text){
	return null;
	
}
public Boolean generalban(String text){
	return null;
}
}
