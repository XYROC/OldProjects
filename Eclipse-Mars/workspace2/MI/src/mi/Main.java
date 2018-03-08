package mi;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.plaf.ProgressBarUI;

public class Main extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	public static SpriteSheet spriteSheetIn = new SpriteSheet(16, 16);
	private JProgressBar progressBar;
	private Font font;
	public static String information;
	
	private Timer timer;
	
	public Main() {
		super("");
		font = new Font("Vardana", 0, 25);
		timer = new Timer(5, this);
		setSize(1040, 640);
		setVisible(false);
		setResizable(false);
		setExtendedState(MAXIMIZED_BOTH);
		progressBar = new JProgressBar();
		progressBar.setVisible(false);
		progressBar.setStringPainted(false);
		progressBar.setValue(0);
		progressBar.setLayout(null);
		progressBar.setBounds(32, 540, 512, 32);
		progressBar.setBackground(Color.GRAY);
		progressBar.setForeground(Color.green);
		progressBar.setVisible(true);
		information = "0%";
		//add(progressBar);
		add(new Panel());
		setLocationRelativeTo(null);
		setIconImage(Texture.NR_PAXE.getImage());
		setVisible(true);
		timer.start();
	}

	public static void main(String[] args) {
		new Main();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == timer){
			information = progressBar.getValue()+"%";
		}
	}

}
