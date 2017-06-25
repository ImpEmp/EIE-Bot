import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class hostile_detect {
public Boolean twitterban(String text){
	
	return null;
	
}
public Boolean is_tagged(String text){
	
	return null;
	
}

public static String leetspeekremover(String input) {
 

    // remove leetspeak
    input = input.replaceAll("1","i");
    input = input.replaceAll("!","i");
    input = input.replaceAll("3","e");
    input = input.replaceAll("4","a");
    input = input.replaceAll("@","a");
    input = input.replaceAll("5","s");
    input = input.replaceAll("7","t");
    input = input.replaceAll("0","o");
    input = input.replaceAll("9","g");
return input;
    }


 


public static String filterText(String input) {
	input = leetspeekremover(input);
	Boolean bad = true;
    if(bad == true)
        return "This message was blocked because a bad word was found. If you believe this word should not be blocked, please message support.";
    
    return " ";
}
public Boolean facebookban(String text){
	return null;
	
}
public Boolean generalban(String text){
	return null;
}
}
