import java.awt.Color; 
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class GameEngine {
	
	// Previous Choice and New Choice JLabels
	
    JLabel previousChoice = new JLabel();
    JLabel newChoice = new JLabel();
    
    // All 4 Choice JButtons
    
	public static JButton button1 = new JButton();
	public static JButton button2 = new JButton();
	public static JButton button3 = new JButton();
	public static JButton button4 = new JButton();
	
	// Boolean to track the creation of the GUI
	public static boolean createdGUI = false;
	
	// All Strings for setting new choices and statements
	
	public static String Previous;
	public static String New;
	public static String choiceA;
	public static String choiceB;
	public static String choiceC;
	public static String choiceD;
	public static String backgroundPath;
	
	public static int optionA = 0;
	public static int optionB = 0;
	public static int optionC = 0;
	public static int optionD = 0;
	
    public JFrame f = new JFrame();
    
    public void initGameEngine() {

    }
    
	public GameEngine() {


	        // Answer Buttons 
			        
	        	previousChoice.setText("Welcome to JAILBREAK.");
	        	newChoice.setText("Click any option to begin.");
	        
		        button1.setText("Continue"); 
		        button2.setText("Continue");
		        button3.setText("Continue");
		        button4.setText("Continue");
		        
		        button1.setBounds(500,200,300,50); // X, Y, Length, Width
		        button2.setBounds(500,250,300,50); 
		        button3.setBounds(500,300,300,50); 
		        button4.setBounds(500,350,300,50);
		        
	   
		if (createdGUI == false) {
		        
		try {
			f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("Black.jpeg")))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("cant find it");
			e.printStackTrace();
		}
		
        previousChoice.setFont(new Font("Serif", Font.PLAIN, 20));
        previousChoice.setForeground(Color.WHITE);
        
        newChoice.setFont(new Font("Serif", Font.PLAIN, 20));
        newChoice.setForeground(Color.WHITE);
        
	    previousChoice.setBounds(500,100,1000,50);
	    newChoice.setBounds(500,125,1000,50);
	    
		f.add(previousChoice);
		f.add(newChoice);
		
		f.add(button1);
		f.add(button2);
		f.add(button3);
		f.add(button4);
		
		f.setSize(1000,1000);
		
		f.pack();
		f.setVisible(true);
	   
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	
		createdGUI = true;
		
		}

			
		button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
            	
            if (optionA == 0) {
            	 
    			try {
					f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("Courtroom.jpeg")))));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	
				previousChoice.setText("You're on trial."); // Previous
				newChoice.setText("You've been accused of tax fraud");
						
				button1.setText("Plead Non-Guilty"); // Choice A
				button2.setText("Plead Guilty"); // Choice B
				button3.setText("Flee the Courtroom");// Choice C
				button4.setText("Jump the Jury"); // Choice D
            	
        		f.add(previousChoice);
        		f.add(newChoice);
        		
        		f.add(button1);
        		f.add(button2);
        		f.add(button3);
        		f.add(button4);
            	
        		f.pack();
        		f.setVisible(true);

        		optionA++;
        		
            		}
    			
            else if (optionA > 0) {
            	
   			try {
					f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("City2.png")))));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
           	
				previousChoice.setText("You can't find anyone."); // Previous
				newChoice.setText("Everyone is gone. Now what?");
						
				button1.setText("Yell out for others."); // Choice A
				button2.setText("Run in the opposite direction."); // Choice B
				button3.setText("Keep Looking for other people.");// Choice C
				button4.setText("Get the high ground"); // Choice D
           	
       		f.add(previousChoice);
       		f.add(newChoice);
       		
       		f.add(button1);
       		f.add(button2);
       		f.add(button3);
       		f.add(button4);
           	
       		f.pack();
       		f.setVisible(true);

           		}
            	 }
        });
        
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                try {
					f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("Cell.jpeg")))));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	
				previousChoice.setText("You were found guilty."); // Previous
				newChoice.setText("You've been locked up. Now what?");
						
				button1.setText("Start screaming"); // Choice A
				button2.setText("Look for tools"); // Choice B
				button3.setText("Call out for other people");// Choice C
				button4.setText("Squeeze through window"); // Choice D
            	
        		f.add(previousChoice);
        		f.add(newChoice);
        		
        		f.add(button1);
        		f.add(button2);
        		f.add(button3);
        		f.add(button4);
            	
        		f.pack();
        		f.setVisible(true);
            }
        });
        
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

            	if (optionC == 0) {

                try {
					f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("City.jpeg")))));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	
				previousChoice.setText("After running, you found a city."); // Previous
				newChoice.setText("The city is trashed. What now?");
						
				button1.setText("Look for answers"); // Choice A
				button2.setText("Find a working car"); // Choice B
				button3.setText("Look for weapons");// Choice C
				button4.setText("Find food and water"); // Choice D
            	
        		f.add(previousChoice);
        		f.add(newChoice);
        		
        		f.add(button1);
        		f.add(button2);
        		f.add(button3);
        		f.add(button4);
            	
        		f.pack();
        		f.setVisible(true);
        		
        		optionC++;
        		
            		}

            
            else if (optionC > 0) {
            		
                    try {
    					f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("Black.jpeg")))));
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
                	
    				previousChoice.setText("You blacked out."); // Previous
    				newChoice.setText("You must've been hit in the head. Now what?");
    						
    				button1.setText("Get Up swinging"); // Choice A
    				button2.setText("Play Dead"); // Choice B
    				button3.setText("Reach for their feet");// Choice C
    				button4.setText("Call out for help"); // Choice D
                	
            		f.add(previousChoice);
            		f.add(newChoice);
            		
            		f.add(button1);
            		f.add(button2);
            		f.add(button3);
            		f.add(button4);
                	
            		f.pack();
            		f.setVisible(true);
                }
            }
        	});


        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

            		
            	
                try {
					f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("Forest.jpeg")))));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	
				previousChoice.setText("You were skinny enough."); // Previous
				newChoice.setText("You stare into a blank forest. What now?");
						
				button1.setText("Tackle a guard"); // Choice A
				button2.setText("Crawl into the bushes"); // Choice B
				button3.setText("Start Running");// Choice C
				button4.setText("Help others get out"); // Choice D
            	
        		f.add(previousChoice);
        		f.add(newChoice);
        		
        		f.add(button1);
        		f.add(button2);
        		f.add(button3);
        		f.add(button4);
            	
        		f.pack();
        		f.setVisible(true);
            }

        });

		}

}
