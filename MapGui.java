/*
 * This class must have all the gui implementation of the game.
 */
//package bomborman;

import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import java.awt.*;
import javax.imageio.*;

public class MapGui extends JPanel{
	static JPanel panel;
	Map map;
	Image bg;
	
	public MapGui(){
		bg = MapBasicBlock.loadImage("resources/background.png");
		map = new Map(15,15);
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
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics g2d = (Graphics2D) g;
		
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
		
		
	}
	
	
}

