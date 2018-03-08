package mainpackage;

import java.awt.*;

import javax.swing.*;
import javax.swing.JPanel;

public class guiMenue extends JPanel{
	
	Image imgM;
	public guiMenue(){
		 
		 setFocusable(true);
		 ImageIcon u = new ImageIcon("C:/JavaT/Menue.png");
		 
		 imgM = u.getImage();
		 
		 
		
		
		
	}
	public void paint(Graphics g){
		super.paint(g);
	
		Graphics2D f2 = (Graphics2D)g;
		
		f2.drawImage(imgM,0,0,null);
		
	}

}
