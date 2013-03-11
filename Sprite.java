
import java.awt.Image;

public class Sprite {

	Image sprites[];
	int alternate;
	
	Sprite(String[] args){
		sprites = new Image[args.length];
		for (int i=0;i<args.length;i++){
			sprites[i] = MapBasicBlock.loadImage(args[i]);
		}
		alternate =0;
	}
	
	public void animatePlayer(int movement){
//		if (movement==0){ //static
//			if (alternate==0){
//				RandomTest.m.p1.setImage(sprites[0]);
//				alternate = 1;
//				return;
//			}
//			else {
//				RandomTest.m.p1.setImage(sprites[1]);
//				alternate = 0;
//				return;
//			}	
//		}
		if (movement==1){ //up
			if (alternate==0){
				RandomTest.m.p1.setImage(sprites[2]);
				alternate = 1;
				return;
			}
			else if (alternate==1){
				RandomTest.m.p1.setImage(sprites[3]);
				alternate = 2;
				return;
			}
			else if (alternate==2){
				RandomTest.m.p1.setImage(sprites[4]);
				alternate = 3;
				return;
			}
			else {
				RandomTest.m.p1.setImage(sprites[5]);
				alternate = 0;
				return;
			}	
		}
		else if (movement==-1){ //down
			if (alternate==0){
				RandomTest.m.p1.setImage(sprites[6]);
				alternate = 1;
				return;
			}
			else if (alternate==1){
				RandomTest.m.p1.setImage(sprites[7]);
				alternate = 2;
				return;
			}
			else {
				RandomTest.m.p1.setImage(sprites[8]);
				alternate = 0;
				return;
			}	
		}
		else if (movement==2){ //right
			if (alternate==0){
				RandomTest.m.p1.setImage(sprites[9]);
				alternate = 1;
				return;
			}
			else if (alternate==1){
				RandomTest.m.p1.setImage(sprites[10]);
				alternate = 2;
				return;
			}
			else if (alternate==2){
				RandomTest.m.p1.setImage(sprites[11]);
				alternate = 3;
				return;
			}
			else if (alternate==3){
				RandomTest.m.p1.setImage(sprites[12]);
				alternate = 4;
				return;
			}
			else if (alternate==4){
				RandomTest.m.p1.setImage(sprites[13]);
				alternate = 5;
				return;
			}
			else {
				RandomTest.m.p1.setImage(sprites[14]);
				alternate = 0;
				return;
			}	
		}
		else if (movement==-2){ //left
			if (alternate==0){
				RandomTest.m.p1.setImage(sprites[15]);
				alternate = 1;
				return;
			}
			else if (alternate==1){
				RandomTest.m.p1.setImage(sprites[16]);
				alternate = 2;
				return;
			}
			else if (alternate==2){
				RandomTest.m.p1.setImage(sprites[17]);
				alternate = 3;
				return;
			}
			else if (alternate==3){
				RandomTest.m.p1.setImage(sprites[18]);
				alternate = 4;
				return;
			}
			else if (alternate==4){
				RandomTest.m.p1.setImage(sprites[19]);
				alternate = 5;
				return;
			}
			else {
				RandomTest.m.p1.setImage(sprites[20]);
				alternate = 0;
				return;
			}	
		}

	}
	
	public void animateBomb(){
		int bR = RandomTest.m.bomb.getPosition().getRow() / 50;
		int bC = RandomTest.m.bomb.getPosition().getColumn() / 50;
		
		if (alternate ==0){
			RandomTest.m.map.map[bR][bC].setImage(sprites[1]);
			alternate = 1;
			return;
		}
		else if (alternate ==1){
			RandomTest.m.map.map[bR][bC].setImage(sprites[2]);
			alternate = 2;
			return;
			
		}
		else {
			RandomTest.m.map.map[bR][bC].setImage(sprites[0]);
			alternate =0;
			return;
		}
		
	}
}
