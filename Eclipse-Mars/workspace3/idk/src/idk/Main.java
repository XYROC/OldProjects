package idk;

import javax.swing.JFrame;

public class Main extends JFrame {
	
	public static void main(String[] args) {
		new Main();
	}
	
	public Main(){
		super();
		setLayout(null);
		setBounds(0, 0, 1000, 1000);
		setContentPane(new Panel());
		setVisible(true);
	}

}