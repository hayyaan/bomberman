

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
    
    static public boolean isValidMove( MapBasicBlock player, Types.Move move){
//    	int playerR=(int) Math.floor((player.getPosition().getRow()) / 50);
//    	int playerC=(int) Math.floor((player.getPosition().getColumn()) / 50);
    	
    	int playerR=0;
    	int playerC=0;
    	
    	if (move == Types.Move.RIGHT || move == Types.Move.DOWN){
    		playerR = (player.getPosition().getRow()-20) /50;
    		playerC = (player.getPosition().getColumn()-20) /50;
    	}
    	else if (move == Types.Move.LEFT || move == Types.Move.UP){
    		playerR = (player.getPosition().getRow()+20) /50;
    		playerC = (player.getPosition().getColumn()+20) /50;
    	}
    	
    	
//    	System.out.println("You are at: "+ player.getPosition().getRow()+ " row:"+playerR);
//    	System.out.println("You are at: "+ player.getPosition().getColumn()+ " col:"+playerC);
    	
//    	MapBasicBlock blockUpLeft = RandomTest.m.map.map[playerR-1][playerC-1];
//    	MapBasicBlock blockUp = RandomTest.m.map.map[playerR][playerC-1];
//    	MapBasicBlock blockUpRight = RandomTest.m.map.map[playerR+1][playerC-1];
//    	
//    	MapBasicBlock blockLeft = RandomTest.m.map.map[playerR-1][playerC];
//    	MapBasicBlock block = RandomTest.m.map.map[playerR][playerC];
//    	MapBasicBlock blockRight = RandomTest.m.map.map[playerR+1][playerC];
//    	
//    	MapBasicBlock blockDownLeft = RandomTest.m.map.map[playerR-1][playerC+1];
//    	MapBasicBlock blockDown = RandomTest.m.map.map[playerR][playerC+1];
//    	MapBasicBlock blockDownRight = RandomTest.m.map.map[playerR+1][playerC+1];
//    	
//    	if (player.getPosition().getRow() <75 || player.getPosition().getRow() >675){
//    		return false;
//    	}
//    	if (player.getPosition().getColumn() <75 || player.getPosition().getColumn() >675){
//    		return false;
//    	}
//    	
//    	if (move == Types.Move.UP){
////    		if (BomborMan.game.map.map[playerR+1][playerC] == null){
//    		if (RandomTest.m.map.map[playerR][playerC-1] != null){
//    			return false;
//    		} 
//    	}
//    	else if(move == Types.Move.DOWN){
//    		if (RandomTest.m.map.map[playerR][playerC+1] != null){// || RandomTest.m.map.map[playerR-1][playerC+1] == null || RandomTest.m.map.map[playerR+1][playerC+1] == null){
//    			return false;
//    		}
//    	}
//    	else if(move == Types.Move.LEFT){
//    		if (RandomTest.m.map.map[playerR-1][playerC] != null){// || RandomTest.m.map.map[playerR-1][playerC+1] == null || RandomTest.m.map.map[playerR-1][playerC-1] == null){
//    			return false;
//    		}
//    	}
//    	else if(move == Types.Move.RIGHT){
////    		if (player.getPosition().getRow()>700){
////    			System.out.println("STOP");
////    			player.position.setPosition(player.getPosition().getRow()-8, player.getPosition().getColumn());
////    			return false;
////    		}
//    		if (RandomTest.m.map.map[playerR+1][playerC] != null){// || RandomTest.m.map.map[playerR+1][playerC+1] == null || RandomTest.m.map.map[playerR+1][playerC-1] == null){
//    			return false;
//    		}
//    	}
//    	
//    	return true;

    	
    	if (move == Types.Move.UP){
    		if (player.getPosition().getColumn() <=75){
    			return false;
    		}
    		if (RandomTest.m.map.map[playerR][playerC-1] == null){
    			return true;
    		}
    	}
    	else if(move == Types.Move.DOWN){
    		if (player.getPosition().getColumn() >=750){
    			return false;
    		}
    		if (RandomTest.m.map.map[playerR][playerC+1] == null){
    			return true;
    		}
    	}
    	else if(move == Types.Move.LEFT){
    		if (player.getPosition().getRow() <=75){
    			return false;
    		}
    		if (RandomTest.m.map.map[playerR-1][playerC] == null){
    			return true;
    		}
    	}
    	else if(move == Types.Move.RIGHT){
    		if (player.getPosition().getRow() >=750){
    			return false;
    		}
    		if (RandomTest.m.map.map[playerR+1][playerC] == null){
    			return true;
    		}
    	}
    	
    	else if(move == Types.Move.PLACE_BOMB){
    		if (RandomTest.m.bomb!=null){
    			System.out.println("Can't place bomb!");
    			return false;
    		}
    		return true;
    	}
    	return false;
    	
//    	for (int r=0;r<15;r++){
//    		for (int c=0;c<15;c++){
//    			if (RandomTest.m.map.map[r][c]==null){
//    				continue;
//    			}
//    			else if (Math.abs(RandomTest.m.map.map[r][c].getPosition().getRow() - player.getPosition().getRow() ) <25 && Math.abs(RandomTest.m.map.map[r][c].getPosition().getColumn() - player.getPosition().getColumn() ) <25){
//    				player.setPosition(new Position(r*50 +25,c*50 +25));
//    				System.out.println("YOLO!");
//    				return false;
//    			}
//    		}
//    	}
//            return true;
    	
    	
    	
    }
}
    
