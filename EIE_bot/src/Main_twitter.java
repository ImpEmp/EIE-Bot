import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;



public class Main_twitter {

    public static void tweet(String tweete) throws FileNotFoundException
    {
        try
        {
            // The factory instance is re-useable and thread safe.
            Twitter twitter = new TwitterFactory().getInstance();
         //   twitter.getOAuthConsumer();

            //twitter4j.auth.AccessToken accessToken = new twitter4j.auth.AccessToken("880054483128111104-bnooexN77uhe0vMo2x6TOhHZ3vopCQ4"," 2DA74krdn7gxlzVbhtKxpIDYRYlVJDHf9pcFMmoO3aD1j");
            //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           
           	 
      	   
   			String out = hostile_detect.filterText(tweete);
   			
   			if (out == "good"){
            Status status = twitter.updateStatus(tweete);
            System.out.println("Successfully updated the status to [" + status.getText() + "].");
   			}
   			if (out == "blocked"){
   	            
   	            System.out.println("[BLOCKED]");
   	   			}
   			
            System.exit(0);
        } catch (TwitterException ex)
        {
            Logger.getLogger(Main_twitter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void block(String tweeter)
    {
        // The factory instance is re-useable and thread safe.
		Twitter twitter = new TwitterFactory().getInstance();

    }
    public static void search(String searche) throws TwitterException
    {
        // The factory instance is re-useable and thread safe.
		Twitter twitter = new TwitterFactory().getInstance();
		  Query query = new Query(searche);
		    QueryResult result = twitter.search(query);
		    for (Status status : result.getTweets()) {
		        System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
		    }

    }
    public static void prowl(String searche) throws TwitterException, FileNotFoundException
    {
        // The factory instance is re-useable and thread safe.
    	Twitter twitter = new TwitterFactory().getInstance();
		  Query query = new Query(searche);
		  hostile_detect tempor = new hostile_detect();
		    QueryResult result = twitter.search(query);
		    for (Status status : result.getTweets()) {
		    	String temp = status.getText();
		        System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
		        if(tempor.generalban(temp)){
		        	twitter.createBlock(status.getUser().getScreenName());
		        }
		    }

    }
 
}
