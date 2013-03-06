/*
 * 
 * This class will holde all the information of the map and will have approperiate
 * methods to perform diffrent tasks on map.
 */
//package bomborman;

import java.awt.*;

public class Map {
    
    private int rows, cols;
    public MapBasicBlock[][] map; 
    
    public Map(int _rows, int _cols){
        rows = _rows;
        cols = _cols;
        map = new MapBasicBlock[rows][cols];
        
        MapGeneration();
    }
    
    public int getRows(){
    	return rows;
    }
    
    public int getCols(){
    	return cols;
    }
    
    public MapBasicBlock[][] getMap(){
    	return map;
    }
    
    public void MapGeneration(){
    	Image uBlock = MapBasicBlock.loadImage("resources/unbreakBlock.png");
    	Image bBlock = MapBasicBlock.loadImage("resources/breakBlock.png");
    	
    	System.out.println("Generated!");
    	
    	for (int r=0;r<rows;r++){
    		for (int c=0;c<cols;c++){
    			if(r==0 || c==0 || r==rows-1 || c==cols-1){ //walls
    				map[r][c] = new UnbreakableBlock(new Position(r,c),uBlock);
    			}
    			else if (r%2 == 0 && c%2==0){ //
    				map[r][c] = new UnbreakableBlock(new Position(r,c),uBlock);
    			}
//    			else if (map[r-1][c]==null && map[r][c-1]==null){ //
//    				map[r][c] = new UnbreakableBlock(new Position(r,c),uBlock);
//    			}
    			else {
    				map[r][c] = null;
    			}
    		}
    	}
    	
    }
    
    
}
