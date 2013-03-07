/*
 * This class will execute the move on the map and change the data and gui 
 * accordingly.
 * 
 * make constructor of this class or other methods if you feel need for it.
 * don't forget dividing your code into classes and methods is good standard
 * practice in professional world.
 */
//package bomborman;


//import bomborman.Types.*;


public class MoveExecutor{
    
	static int movement = 5;
    
    static public void executeMove( Player player, Types.Move move){
    	Position newPos = null;
    	if (move == Types.Move.UP){
    		newPos = new Position(player.getPosition().getRow(),player.getPosition().getColumn()-movement);
    	}
    	else if(move == Types.Move.DOWN){
    		newPos = new Position(player.getPosition().getRow(),player.getPosition().getColumn()+movement);
    	}
    	else if(move == Types.Move.LEFT){
    		newPos = new Position(player.getPosition().getRow()-movement,player.getPosition().getColumn());
    	}
    	else if(move == Types.Move.RIGHT){
    		newPos = new Position(player.getPosition().getRow()+movement,player.getPosition().getColumn());
    	}
    	else if(move == Types.Move.PLACE_BOMB){
    		int playerR=(int) Math.floor(player.getPosition().getRow() / 50);
        	int playerC=(int) Math.floor(player.getPosition().getColumn() / 50);
        	newPos = new Position(5,3);
        		RandomTest.m.map.map[5][3] = new Bomb(newPos);
        		System.out.println("BOMB Planted!");
    	}
    	
    	if (newPos!=null)
    		player.setPosition(newPos);
    	
//		BomborMan.game.repaint();
    	RandomTest.m.repaint();

    }
    
}
