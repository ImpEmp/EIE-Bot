import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.net.ssl.SSLEngineResult.Status;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class twitter_prowler {
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		hostile_detect d = new hostile_detect ();
	    Twitter twitter = TwitterFactory.getSingleton();
	    twitter4j.Status status = null;
		try {
			status = twitter.updateStatus("latestStatus");
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("Successfully updated the status to [" + status.getText() + "].");
		System.out.print("enter in the test>>>");
		Scanner scanner = new Scanner(System.in);
		String test = scanner.nextLine();
		System.out.print(d.filterText(test));
	}

}
