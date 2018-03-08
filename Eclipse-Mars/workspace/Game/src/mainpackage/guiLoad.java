package mainpackage;

import javax.swing.*;
import java.awt.*;

public class guiLoad extends JPanel{
	
	Image img;
	
	public guiLoad(){
		ImageIcon u = new ImageIcon("C:/JavaT/Load.png");
		img = u.getImage();
		
		
		
	}
	public void paint(Graphics g){
		super.paint(g);
		
		Graphics2D f2 = (Graphics2D) g;
		f2.drawImage(img,0,0,null );
		
	}
	

}
