import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;



public class Main_twitter {

    public static void tweet(String tweete)
    {
        try
        {
            // The factory instance is re-useable and thread safe.
            Twitter twitter = new TwitterFactory().getInstance();
         //   twitter.getOAuthConsumer();

            //twitter4j.auth.AccessToken accessToken = new twitter4j.auth.AccessToken("880054483128111104-bnooexN77uhe0vMo2x6TOhHZ3vopCQ4"," 2DA74krdn7gxlzVbhtKxpIDYRYlVJDHf9pcFMmoO3aD1j");
            //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            Status status = twitter.updateStatus(tweete);
            System.out.println("Successfully updated the status to [" + status.getText() + "].");
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
    public static void search(String searche)
    {
        // The factory instance is re-useable and thread safe.
		Twitter twitter = new TwitterFactory().getInstance();

    }
}