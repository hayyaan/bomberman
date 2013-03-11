import javax.swing.JFrame;


public class RandomTest {
	
	static MapGui m;
	
	public static void main(String[] args){
		System.out.println("here");

	JFrame f =new JFrame();
	m=new MapGui();
	f.add(m);
	f.setSize(765,795);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setLocationRelativeTo(null);
	f.setVisible(true);
	
	
//	System.out.println("column: "+m.p1.getPosition().getColumn());
	
	
	
	}
}
