/*
 * In this class you will instentialte other classes and game playe will be
 * implemented here.
 */
//package bomborman;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Dimension;

public class BomborMan {
	JFrame mainFrame;
	JPanel mainMenu;
	MapGui game;
	JPanel help; //need to make a class of this

	BomborMan(){
		mainFrame = new JFrame("Bomborman version 1.0");
		mainMenu = new JPanel();
	}

	void initMainMenu(){
		mainMenu.setLayout(new BoxLayout(mainMenu, BoxLayout.PAGE_AXIS));
		JButton play = new JButton("Play Game!");
		JButton help = new JButton("Help");
		JButton exit = new JButton("Exit");
		mainMenu.add(Box.createRigidArea(new Dimension(50,50)));
		mainMenu.add(Box.createRigidArea(new Dimension(50,0)));
		mainMenu.add(play);
		mainMenu.add(Box.createRigidArea(new Dimension(0,10)));
		mainMenu.add(Box.createRigidArea(new Dimension(50,0)));
		mainMenu.add(help);
		mainMenu.add(Box.createRigidArea(new Dimension(50,0)));
		mainMenu.add(Box.createRigidArea(new Dimension(0,10)));
		mainMenu.add(exit);
		
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				System.exit(1);
			}
		});
		

		mainFrame.add(mainMenu);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.pack();
		mainFrame.setSize(200,300);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
	}


    
    public static void main(String[] args) {
        // gmae should run here
    	try{
    	UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    	} catch (UnsupportedLookAndFeelException e) {
    	       // handle exception
        }
        catch (ClassNotFoundException e) {
           // handle exception
        }
        catch (InstantiationException e) {
           // handle exception
        }
        catch (IllegalAccessException e) {
           // handle exception
        }
        BomborMan run = new BomborMan();
        
        run.initMainMenu();
        
    }
}
