import java.awt.List;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
	//private static final String FILENAME = "blocking.txt";
	public static void ptfile(String text) throws IOException{
	    
	        BufferedWriter output = null;
	        try {
	            File file = new File("output.txt");
	            output = new BufferedWriter(new FileWriter(file));
	            output.write(text);
	        } catch ( IOException e ) {
	            e.printStackTrace();
	        } finally {
	          if ( output != null ) {
	            output.close();
	          }
	        }
	}
	
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

    public static void bettersearch(String term)
    {
    	Twitter twitter = new TwitterFactory().getInstance();
    ArrayList<Status> tweets = new ArrayList<Status>();
    int wantedTweets = 200;
    long lastSearchID = Long.MAX_VALUE;
    int remainingTweets = wantedTweets;
    Query query = new Query(term);
     try
    { 

      while(remainingTweets > 0)
      {
        remainingTweets = wantedTweets - tweets.size();
        if(remainingTweets > 100)
        {
          query.count(100);
        }
        else
        {
         query.count(remainingTweets); 
        }
        QueryResult result = twitter.search(query);
        tweets.addAll(result.getTweets());
        Status s = tweets.get(tweets.size()-1);
        long firstQueryID = s.getId();
        query.setMaxId(firstQueryID);
        remainingTweets = wantedTweets - tweets.size();
      }

      System.out.println("tweets.size() "+tweets.size() );
    }
    catch(TwitterException te)
    {
      System.out.println("Failed to search tweets: " + te.getMessage());
      System.exit(-1);
    }
    }
    public static void betterprowl(String term,int number) throws TwitterException, IOException{
    	Twitter twitter = new TwitterFactory().getInstance();
        ArrayList<Status> tweets = new ArrayList<Status>();
        int wantedTweets = 200;
        long lastSearchID = Long.MAX_VALUE;
        int remainingTweets = wantedTweets;
        Query query = new Query(term);
         try
        { 
             // The factory instance is re-useable and thread safe.
    
     		  hostile_detect tempor = new hostile_detect();
     		  

          while(remainingTweets > 0)
          {
            remainingTweets = wantedTweets - tweets.size();
            if(remainingTweets > 100)
            {
              query.count(100);
            }
            else
            {
             query.count(remainingTweets); 
            }
            QueryResult result = twitter.search(query);
            tweets.addAll(result.getTweets());
            Status s = tweets.get(tweets.size()-1);
            long firstQueryID = s.getId();
            query.setMaxId(firstQueryID);
            for (Status status : result.getTweets()) {
 		    	String temp = status.getText();
 		        System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
 		        ptfile("@" + status.getUser().getScreenName() + ":" + status.getText());
 		        String why = status.getUser().getScreenName();
 		        if(tempor.generalban(temp)==true&&!(status.getUser().getScreenName() =="Shodan_Freeman")){
 		        	twitter.createBlock(why);
 		        }
 		    }
            remainingTweets = wantedTweets - tweets.size();
          }

          System.out.println("tweets.size() "+tweets.size() );
        }
        catch(TwitterException te)
        {
          System.out.println("Failed to search tweets: " + te.getMessage());
          System.exit(-1);
        }
    }
    public static void prowl(String searche) throws TwitterException, IOException
    {
        // The factory instance is re-useable and thread safe.
    	Twitter twitter = new TwitterFactory().getInstance();
    	String temp = null;
		  Query query = new Query(searche);
		  hostile_detect tempor = new hostile_detect();
		    QueryResult result = twitter.search(query);
		    for (Status status : result.getTweets()) {
		    	temp = status.getText();
		        System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
		        ptfile("@" + status.getUser().getScreenName() + ":" + status.getText());
		        String why = status.getUser().getScreenName();
		        if(tempor.generalban(temp)==true&&!(status.getUser().getScreenName() =="Shodan_Freeman")){
		        	twitter.createBlock(why);
		        }
		    }

    }
 
}
