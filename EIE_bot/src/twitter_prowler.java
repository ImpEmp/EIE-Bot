import java.awt.*;        // Using AWT container and component classes
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import twitter4j.TwitterException;
 
// An AWT program inherits from the top-level container java.awt.Frame
public class twitter_prowler extends Frame
implements ActionListener, WindowListener {
   private Label lblCount;    // Declare a Label component 
   private TextField tfCount; // Declare a TextField component 
   private Button btnCount;   // Declare a Button component
   private String count = "nuller";     // Counter's value
   private String out = "null";
   // Constructor to setup GUI components and event handlers
   public twitter_prowler () {
	  
      setLayout(new FlowLayout());
      
         // "super" Frame, which is a Container, sets its layout to FlowLayout to arrange
         // the components from left-to-right, and flow to next row from top-to-bottom.
 
      lblCount = new Label("Counter");  // construct the Label component
      add(lblCount);                    // "super" Frame container adds Label component
 
      tfCount = new TextField(count, 10); // construct the TextField component
      tfCount.setEditable(true);       // set to read-only
      add(tfCount);                     // "super" Frame container adds TextField component
      addWindowListener(this);
      btnCount = new Button("post");   // construct the Button component
      add(btnCount);                    // "super" Frame container adds Button component
      TextField tfout = new TextField(out, 10); // construct the TextField component
      tfout.setEditable(false);  
      add(tfout);
      btnCount.addActionListener(new ActionListener(){
    	  @Override
    	  public void actionPerformed(ActionEvent evt) 
    	   {
    		  count=tfCount.getText();
    		  int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to Tweet?", "Tweet?",  JOptionPane.YES_NO_OPTION);
    		  if (reply == JOptionPane.YES_OPTION)
    		  {
    		 
    		  
    	      Main_twitter tweeter = new Main_twitter();
    	      try {
				Main_twitter.tweet(count);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		  }
    	   }
    		  
});
         // "btnCount" is the source object that fires an ActionEvent when clicked.
         // The source add "this" instance as an ActionEvent listener, which provides
         //   an ActionEvent handler called actionPerformed().
         // Clicking "btnCount" invokes actionPerformed().
 
      setTitle("post");  // "super" Frame sets its title
      setSize(250, 250);        // "super" Frame sets its initial window size
      setVisible(true);         // "super" Frame shows
      Button btnCountUp = new Button("block");
      add(btnCountUp);
      // Construct an anonymous instance of an anonymous inner class.
      // The source Button adds the anonymous instance as ActionEvent listener
      btnCountUp.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
       
         }
      });
 
      Button btnCountDown = new Button("search");
      add(btnCountDown);
      btnCountDown.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
        	 count=tfCount.getText();
        	 try {
				Main_twitter.search(count);
			} catch (TwitterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         }
      });
 
      Button btnprowl = new Button("prowl");
      add(btnprowl);
      btnprowl.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
          	 count=tfCount.getText();
      	      Main_twitter tweeter = new Main_twitter();
      	      try {
   			Main_twitter.prowl(count);
   			
   		} catch (FileNotFoundException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         }
         
      });
      Button btnagro = new Button("agro");
      add(btnagro);
      btnagro.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
        	 count=tfCount.getText();
   	      Main_twitter tweeter = new Main_twitter();
   	      try {
			out = hostile_detect.filterText(count);
			tfout.setText(out);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         }
   });
   }
 
   // The entry main() method
   public static void main(String[] args) {
      // Invoke the constructor to setup the GUI, by allocating an instance
      twitter_prowler app = new twitter_prowler();
   }
 
   // ActionEvent handler - Called back upon button-click.
   @Override
 
   public void windowClosing(WindowEvent evt) {
      System.exit(0);  // Terminate the program
   }
 
   // Not Used, but need to provide an empty body to compile.
   public void windowOpened(WindowEvent evt) { }
   public void windowClosed(WindowEvent evt) { }
   public void windowIconified(WindowEvent evt) { }
   public void windowDeiconified(WindowEvent evt) { }
   public void windowActivated(WindowEvent evt) { }
   public void windowDeactivated(WindowEvent evt) { }

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
}