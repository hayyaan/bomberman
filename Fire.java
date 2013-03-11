/*
 * The fire caused by explosion of bomb it stays for some duration of time if 
 * player comes at the place where there is fire then the player will die.
 */
//package bomborman;


public class Fire extends MapBasicBlock{
    
	
    public Fire(Position _position){
        
        super( Types.BlockType.FIRE,_position, MapBasicBlock.loadImage("resources/fire1.gif"));
    }
}
