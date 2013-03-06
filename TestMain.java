
import java.awt.Color;

import javax.swing.*;

public class TestMain {
	static public void main(String argv[]){
		JFrame f = new JFrame("hello");
		f.setSize(765, 795);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		MapGui gui = new MapGui();
		f.setBackground(Color.white);
		
		ImageIcon image = new ImageIcon("resources/background.png");
		JLabel iLabel = new JLabel(image);
		f.add(iLabel);
		
		f.add(gui);
		f.setVisible(true);
	}
}
