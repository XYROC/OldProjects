package mainpackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class frame extends JFrame implements ActionListener {

	private JButton Start;
	private JButton Settings;
	private JButton Info;
	private JButton Exit;
	
	
	public static String Version ="0.1";
	

	public static void main(String[] args) {

		System.out.println("Starting");
		JProgressBar pgr = new JProgressBar();
		
		
		JFrame loadframe = new JFrame();	
		loadframe.setSize(640,400);
		loadframe.setLayout(null);
		loadframe.setResizable(false);
		loadframe.add(new guiLoad());
		//loadframe.add(pgr);
		loadframe.setVisible(true);
		
		
		
		frame frame = new frame("Menue");
		frame.add(new guiMenue());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		
		
		

	}
	
		
		
	

	public frame(String title) {
		super(title);

		Start = new JButton("Start Game");
		Start.setBounds(120, 40, 160, 40);
		Start.addActionListener(this);
		add(Start);

		Settings = new JButton("Settings");
		Settings.setBounds(120, 120, 160, 40);
		Settings.addActionListener(this);
		add(Settings);

		Info = new JButton("Information");
		Info.setBounds(120, 200, 160, 40);
		Info.addActionListener(this);
		
		add(Info);

		Exit = new JButton("Exit");
		Exit.setBounds(120, 280, 160, 40);
		Exit.addActionListener(this);
		add(Exit);

	}
	

	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == Start) {
			window();

		}
		if (evt.getSource() == Settings) {

			GameOptions();

		}
		if (evt.getSource() == Info) {
			Object[] option = { "OK" };

			JOptionPane.showOptionDialog(null, "Version: "+frame.Version+" Programmed by XIROC", "Information",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, option, option[0]);

		}
		if (evt.getSource() == Exit) {

			System.exit(0);

		}

	}

	public static void window() {
		JFrame window = new JFrame();
		window.setTitle("Terminity "+frame.Version);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(1680,1280);
		window.setVisible(true);
		window.add(new gui());
		window.setResizable(false);
	}
	public static void GameOptions(){
		
		
		
		
		
		
	}


	
}
