import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.*;


public class tester {

	public static void main(String[] args) throws FileNotFoundException, TwitterException {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		hostile_detect d = new hostile_detect ();
		ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
            .setOAuthConsumerKey("sHkKDCyejm1mCbWvSM7ZlX5BJ")
            .setOAuthConsumerSecret("ldqJ4mbQCl4kuIs2PQj111xgGqWoyfkEnYs3J3jLBqUPKJ2K7S")
            .setOAuthAccessToken(" 880054483128111104-bnooexN77uhe0vMo2x6TOhHZ3vopCQ4")
            .setOAuthAccessTokenSecret("2DA74krdn7gxlzVbhtKxpIDYRYlVJDHf9pcFMmoO3aD1j");
        //Twitter twitter = tf.getInstance();
               // twitter.updateStatus("This is a test message");
                Twitter twitter = TwitterFactory.getSingleton();
                Status status = twitter.updateStatus("latestStatus");
                System.out.println("Successfully updated the status to [" + status.getText() + "].");//ThrowsTwitterException
	}

}
