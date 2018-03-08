package gtest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Main extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	public static String[][] table;
	public static int lines = 0;
	public static int maxLineLength = 0;
	
	
	public Main(String file) throws IOException {
		super("test");
		readFile(file);
		setLayout(null);
		setBounds(0, 0, 1920, 1080);
		setResizable(false);
		setContentPane(new Panel());
		setVisible(true);
	}
	
	public static void main(String[] args) throws IOException {
		if(args.length == 1){
			new Main(args[0]);
		}else{
			System.err.println("No file selected.");
		}
	}
	
	public static void readFile(String path) throws IOException{
		File file = new File(path);
		if(!file.exists()) return;
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = reader.readLine();
		ArrayList<String> lines = new ArrayList<String>();
		int lineCounter = 0;
		int maxLength = 0;
		while(line != null){
			lineCounter++;
			lines.add(line);
			int length = line.split(";").length;
			if(length > maxLength) maxLength = length;
			line = reader.readLine();
		}
		reader.close();
		table = new String[lineCounter][maxLength];
		for(int i = 0;i < lines.size();i++){
			String[] content = lines.get(i).split(";");
			for(int j = 0; j < maxLength; j++){
				if(j > content.length - 1){
					table[i][j] = null;
					continue;
				}
				table[i][j] = content[j];
			}
		}
		Main.lines = lineCounter;
		Main.maxLineLength = maxLength;
		System.out.println("Finished reading "+path);
	}

}
