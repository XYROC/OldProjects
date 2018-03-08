package mainpackage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.*;
import javax.swing.Timer;

public class gui extends JPanel implements ActionListener{
	
	Timer time;
	Image img;
	int key;
	int went;
	int X_PIC;
	int nx,nx2;
	int count = 0;
	int count2 = 0;

	
	public gui(){
		
		nx= 0;
		nx2 = 1280;
		key = 0;
		went = 0;
		
		setFocusable(true);
		ImageIcon u = new ImageIcon("C:/JavaT/bg.png");
		img = u.getImage();
		addKeyListener(new AL());
		time = new Timer(5,this);
		time.start();
	}
	
	public void actionPerformed(ActionEvent e) {
				mov();
				repaint();
		
	}
	public void paint(Graphics g){
		super.paint(g);
		
		
		
		Graphics2D f2 = (Graphics2D)g;
		
		if(getXPIC() == 1+(count*3360)){
			
			count += 1;
			nx = 0;
			
		}
		if(getXPIC() == 1681+(count2+3360)){
			count2 += 1;
			nx2 = 0;
			
		}
		
		
		
		
		
		
		if(getXPIC() >= 1){
			f2.drawImage(img,1275-nx,0,null);
		}
		f2.drawImage(img,1275-nx2,0,null);
		
		
		
	}
	private int getXPIC(){
		
		return X_PIC;
		
		
	}
	public void mov(){
		
		X_PIC += went;
		nx += went;
		nx2 += went;
		
	}
	
	private class AL extends KeyAdapter{
		public AL(){
			
			
		}
		
		public void keyPressed(KeyEvent kevt){
			
			key = kevt.getKeyCode();
			
			if(key == KeyEvent.VK_LEFT){
				
				went = -2;
			}
			if(key == KeyEvent.VK_RIGHT){
				
				went = 2;
			}
			
			
		}
		public void keyReleased(KeyEvent kevt){
			
			key = kevt.getKeyCode();
			
			if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT){
				went = 0;
				
			}
			
			
			
			
		}
		
		
		


		
	}


	

	
	

}
