/**
 * This class will focus on the implementation of the whether the move picked by
 * a player is valid ( It must not contain any gui related component and
 * nothing of gui can be changed from here). you can define other methods 
 * to assist your self and manage your code.
 * 
 * You can make constructor of this class if you feel need for it.
 * 
 */
//package bomborman;


//import bomborman.Types.*;


public class MoveEvaluator {
    
    static public boolean isValidMove( Player player, Types.Move move){
    	int playerR=(int) Math.floor(player.getPosition().getRow() / 50)+1;
    	int playerC=(int) Math.floor(player.getPosition().getColumn() / 50)+1;
    	
//    	int PlayerR = player.getPosition().getRow() /50;
//    	int PlayerC = player.getPosition().getColumn() /50;
    	
    	System.out.println("You are at: "+ player.getPosition().getRow()+ " row:"+playerR);
    	System.out.println("You are at: "+ player.getPosition().getColumn()+ " col:"+playerC);
    	
    	if (move == Types.Move.UP){
//    		if (BomborMan.game.map.map[playerR+1][playerC] == null){
    		if (RandomTest.m.map.map[playerR][playerC-1] == null){// || RandomTest.m.map.map[playerR-1][playerC-1] == null || RandomTest.m.map.map[playerR+1][playerC-1] == null){
    			return true;
    		} 
    	}
    	else if(move == Types.Move.DOWN){
    		if (RandomTest.m.map.map[playerR][playerC+1] == null){// || RandomTest.m.map.map[playerR-1][playerC+1] == null || RandomTest.m.map.map[playerR+1][playerC+1] == null){
    			return true;
    		}
    	}
    	else if(move == Types.Move.LEFT){
    		if (RandomTest.m.map.map[playerR-1][playerC] == null){// || RandomTest.m.map.map[playerR-1][playerC+1] == null || RandomTest.m.map.map[playerR-1][playerC-1] == null){
    			return true;
    		}
    	}
    	else if(move == Types.Move.RIGHT){
    		if (RandomTest.m.map.map[playerR+1][playerC] == null){// || RandomTest.m.map.map[playerR+1][playerC+1] == null || RandomTest.m.map.map[playerR+1][playerC-1] == null){
    			return true;
    		}
    	}
    	else if(move == Types.Move.PLACE_BOMB){
    		return true;
    	}

            return false;
    }
}
    
