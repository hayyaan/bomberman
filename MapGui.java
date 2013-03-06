/*
 * This class must have all the gui implementation of the game.
 */
//package bomborman;

import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

import javax.imageio.*;

public class MapGui extends JPanel implements KeyListener,ActionListener{
	static JPanel panel;
	Map map;
	Image bg;
	Player p1;
	MoveEvaluator moveEval;
	MoveExecutor moveExec;
	Timer time = new Timer(8,this);
	
	int movement;
	

	public MapGui(){
		bg = MapBasicBlock.loadImage("resources/background.png");
		map = new Map(15,15);
		p1 = new Player();
		time.start();
		
		this.addKeyListener(this);
		this.setFocusable(true);
		this.requestFocus();
		this.setFocusTraversalKeysEnabled(true);	
	}
	
	static void switchMenu(){
		//BomborMan.mainFrame.remove(BomborMan.mainMenu);
		
		JFrame frame = new JFrame();
		
		frame.add(panel);
		frame.setSize(500,500);
		frame.setVisible(true);
		
//		BomborMan.mainFrame.add(panel);
//		BomborMan.mainFrame.setSize(500,500);
//		BomborMan.mainFrame.setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e){
		if (movement ==1){
			MoveExecutor.executeMove(p1, Types.Move.UP);
		}
		else if (movement==-1){
			MoveExecutor.executeMove(p1, Types.Move.DOWN);
		}
		else if (movement ==2){
			MoveExecutor.executeMove(p1, Types.Move.RIGHT);
		}
		else if (movement ==-2){
			MoveExecutor.executeMove(p1, Types.Move.LEFT);
		}
		
	}
	
	public void keyReleased(KeyEvent e){
		movement =0;
	}
	
	public void keyTyped(KeyEvent e){
		movement =0;
	}
	
	public void keyPressed(KeyEvent e){
		System.out.println(e.getKeyCode());
		
		if (e.getKeyCode()==KeyEvent.VK_UP){
			System.out.println("Pressed UP!");
			if (MoveEvaluator.isValidMove(p1,Types.Move.UP)){
			movement = 1;
			}
			
//				MoveExecutor.executeMove(p1, Types.Move.UP);
//			}
		}
		else if (e.getKeyCode()==KeyEvent.VK_DOWN){
			System.out.println("Pressed DOWN!");
			if (MoveEvaluator.isValidMove(p1,Types.Move.DOWN)){
				movement = -1;
			}
		}
		else if (e.getKeyCode()==KeyEvent.VK_LEFT){
			System.out.println("Pressed LEFT!");
			if (MoveEvaluator.isValidMove(p1,Types.Move.LEFT)){
				movement = -2;
			}
		}
		else if (e.getKeyCode()==KeyEvent.VK_RIGHT){
			System.out.println("Pressed RIGHT!");
			if (MoveEvaluator.isValidMove(p1,Types.Move.RIGHT)){
				movement =2;
			}
		}
		
	}
	
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics g2d = (Graphics2D) g;
//		System.out.println("I drew!");
		
		g2d.drawImage(bg,0,0,bg.getWidth(null),bg.getHeight(null),null);
		
		
		for (int r=0;r<map.getRows();r++){
			for (int c=0;c<map.getCols();c++){
				if (map.map[r][c]==null){
					continue;
				}
				else{
				g2d.drawImage((map.map[r][c].getImage()) , (r*50) , (c*50) ,(map.map[r][c].getImage().getWidth(null)) ,(map.map[r][c].getImage().getHeight(null)),null);
				}
			}
		}
		
		g2d.drawImage(p1.getImage(),p1.getPosition().getRow(),p1.getPosition().getColumn(),p1.getImage().getWidth(null),p1.getImage().getHeight(null),null);
		
	}
	
	
}

