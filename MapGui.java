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
	Enemy e1;
	MoveEvaluator moveEval;
	MoveExecutor moveExec;
	Timer time = new Timer(8,this);
	
	int movement;
	int playerStep = 5;
	
	Bomb bomb;
	boolean bombToggle;
	int bombTimer;
	
	boolean fire;
	int fireTimer;
	
	boolean gameEnd;
	boolean gameOver;
	

	public MapGui(){
		bg = MapBasicBlock.loadImage("resources/background.png");
		map = new Map(15,15);
		p1 = new Player();
		
		time.start();
		
		e1 = new Enemy(new Position((7*50)+25,(7*50)+25));
		
		bomb=null;
		
		this.addKeyListener(this);
		this.setFocusable(true);
		this.requestFocus();
		this.setFocusTraversalKeysEnabled(true);	
	}
	
	public void actionPerformed(ActionEvent e){
		
//		System.out.println(bomb);
		
		
		if (movement ==1){
			MoveExecutor.executeMove(p1, Types.Move.UP,playerStep);
		}
		else if (movement==-1){
			MoveExecutor.executeMove(p1, Types.Move.DOWN,playerStep);
		}
		else if (movement ==2){
			MoveExecutor.executeMove(p1, Types.Move.RIGHT,playerStep);
		}
		else if (movement ==-2){
			MoveExecutor.executeMove(p1, Types.Move.LEFT,playerStep);
		}
		RandomTest.m.p1.sprites.animatePlayer(movement);
		
		
		if (e1 !=null){
			e1.moveEnemy();
//			e1.killPlayer();
		}
		
		
		if (bombToggle == true){
//			System.out.println("Hello");
			MoveExecutor.executeMove(p1, Types.Move.PLACE_BOMB,playerStep);
			bombTimer = 300;
			bombToggle = false;
		}
		
		if (bombTimer==1){
			//explosion
			MoveExecutor.explodeBomb(bomb);
			System.out.println("Explosion");
			bombTimer--;
			fireTimer = 20;
		}
		
		else if (bombTimer>0){
			bombTimer--;
			bomb.sprites.animateBomb();
		}
		
		
		if (fire ==true){
			fireTimer--;
		}
		
		if (fireTimer <0){
			fire=false;
		}
		
		if (map.checkEnd()){ //if all boxes cleared
			gameEnd = true;
			System.out.println("Game Over!\n You won!");
		}
		
		if (gameOver==true){ //if player dies
			System.out.println("You died!");
			time.stop();
//			e1 = null;
		}
		
		
		
		
		
		
		movement=0;
		
	}
	
	public void keyReleased(KeyEvent e){
		movement =0;
//		bomb = false;
	}
	
	public void keyTyped(KeyEvent e){
		movement =0;
//		bomb = false;
	}
	
	public void keyPressed(KeyEvent e){
//		System.out.println(e.getKeyCode());
		
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
		else if (e.getKeyCode()==KeyEvent.VK_SPACE){
			System.out.println("Pressed SPACE!");
//			System.out.println(bombToggle);
			if (MoveEvaluator.isValidMove(p1,Types.Move.PLACE_BOMB)){
//				System.out.println("Icant");
				bombToggle =true;
//				System.out.println(bomb);
			}
		}
		
//		if (movement ==1){
//			MoveExecutor.executeMove(p1, Types.Move.UP);
//		}
//		else if (movement==-1){
//			MoveExecutor.executeMove(p1, Types.Move.DOWN);
//		}
//		else if (movement ==2){
////			System.out.println(e1.isofType(Types.BlockType.ENEMY));
////			MoveExecutor.executeMove(e1, Types.Move.RIGHT);
//			MoveExecutor.executeMove(p1, Types.Move.RIGHT);
//			
//		}
//		else if (movement ==-2){
//			MoveExecutor.executeMove(p1, Types.Move.LEFT);
//		}
		
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
		
//		if (bomb !=null){
//			g2d.drawImage(bomb.getImage(),bomb.getPosition().getRow()-25,bomb.getPosition().getColumn()-25,bomb.getImage().getWidth(null),bomb.getImage().getHeight(null),null);
//			}
		
		g2d.drawImage(p1.getImage(),p1.getPosition().getRow()-25,p1.getPosition().getColumn()-25,p1.getImage().getWidth(null),p1.getImage().getHeight(null),null);
		

		
		if (e1 !=null){
		g2d.drawImage(e1.getImage(),e1.getPosition().getRow()-25,e1.getPosition().getColumn()-25,e1.getImage().getWidth(null),e1.getImage().getHeight(null),null);
		}
	}
	
	
}

