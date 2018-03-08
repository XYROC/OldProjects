package installer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import src.datautils.file.FileManager;


public class Main implements ActionListener{
	
	JFrame frame;
	JButton field_00a;
	JButton field_01b;
	JProgressBar field_00b;
	JLabel field_01a;
	JComboBox<String> field_00c;
	
	String DOWNLOAD;
	
	private String version;
	public static final String adress = "https://www.dropbox.com/s/rnyjz8o5w2y0k8f/adventurecraft-version.txt?dl=1";

	public static void main(String[] args) {
		Main main = new Main();
	}
	public Main() {
		frame = new JFrame("");
		frame.setLayout(null);
		frame.setSize(940, 600);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		field_00b = new JProgressBar(0, 200);
		field_00b.setValue(0);
		field_00b.setLayout(null);
		field_00b.setStringPainted(true);
		field_00b.setVisible(false);
		field_00a = new JButton("Download");
		field_00a.setBounds(30, 40, 200, 40);
		field_00b.setBounds(30, 490, 860, 35);
		field_00b.setBackground(Color.white);
		field_00a.addActionListener(this);
		field_01b = new JButton("FileManager Test");
		field_01b.setBounds(250, 40, 200, 40);
		field_01b.addActionListener(this);
		field_00c = new JComboBox<String>();
		field_00c.setVisible(true);
		field_00c.setBounds(30, 120, 400, 50);
		field_01a = new JLabel();
		field_01a.setBounds(30, 300, 300, 100);
		field_01a.setVisible(true);
		frame.setVisible(true);
		frame.add(field_00a);
		frame.add(field_00b);
		frame.add(field_00c);
		frame.add(field_01a);
		frame.add(field_01b);
		version = "0.0";
		DOWNLOAD = System.getProperty("user.home")+"/Downloads";
		load();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == field_00a){
			field_00a.setEnabled(false);
			field_00b.setVisible(true);
			field_00b.setValue(0);
			field_00b.setString("Vorbereitung...");
			URL url;
			try {
				url = new URL(adress);
				InputStream in = url.openStream();
				FileOutputStream out = new FileOutputStream(new File(DOWNLOAD+"/"+field_00c.getSelectedItem()+".txt"));
				field_00b.setValue(0);
				field_00b.setString("0%");
				int l = -1;
				byte[] buffer = new byte[1024];
				while ((l = in.read(buffer)) > -1) {
				    out.write(buffer, 0, l);
					field_00b.setString((buffer.length)/(buffer.length-l)*200+"%");
					field_00b.setValue((buffer.length)/(buffer.length-l));
				}
				out.close();
				in.close();
			} catch (IOException ex) {
				ex.printStackTrace();
				field_00b.setValue(200);
				field_00b.setString("Download fehlgeschlagen");
				field_00a.setEnabled(true);
			}
			field_00b.setValue(200);
			field_00b.setString("Download abgeschlossen");
			field_00a.setEnabled(true);
		}
		if(e.getSource() == field_01b){
			FileManager manager = new FileManager(new File(System.getProperty("user.home")+"/Documents/FileManagerTestFile.xcfg"));
			try {
				manager.readFile();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	public void load() {
		URL url;
		try {
			field_00b.setVisible(true);
			field_00a.setEnabled(false);
			field_00b.setString("Lade Updates... 0%");
			field_00b.setValue(0);
			field_00c.setEnabled(false);
			url = new URL(adress);
			Scanner scanner = new Scanner(url.openStream());
			int versions = Integer.valueOf(scanner.nextLine());
			for(int i = 0;i<versions;i++){
				field_00c.addItem("adventureCraft "+scanner.nextLine());
			}
			scanner.close();
			field_00c.setEnabled(true);
			field_00b.setValue(200);
			field_00b.setString("Lade Updates... 100%");
			field_00a.setEnabled(true);
			field_00b.setVisible(false);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
