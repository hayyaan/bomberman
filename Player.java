/*
 * this the player class, it will maintain the data of player and have 
 * approperiate methods.
 * 
 */
//package bomborman;

import java.awt.Image;
//import bomborman.Types.*;


public class Player extends MapBasicBlock {
    
    private boolean alive;
    private int playerID;
    
    public Player(){    	
        super(Types.BlockType.PLAYER,new Position(50,50),loadImage("resources/b1.gif"));
        alive = true;
        playerID++;
    }
    
}
