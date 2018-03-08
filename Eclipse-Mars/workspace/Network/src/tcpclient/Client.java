package tcpclient;

import java.io.*;
import java.net.*;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTextArea textArea;
	private JTextField commandLine;
	
	public Client() {
		super();
		setVisible(false);
		setLayout(null);
		setSize(800, 600);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setResizable(false);
		textArea = new JTextArea();
		textArea.setBounds(400, 10, 350, 500);
		textArea.setEditable(false);
		commandLine = new JTextField();
		commandLine.setBounds(20, 500, 550, 50);
		add(textArea);
		add(commandLine);
		setVisible(true);
	}

	public static void main(String[] args) throws IOException {
		new Client();
		/*
		System.out.println("##############");
		System.out.println("Network Client");
		System.out.println("##############");
		String sentence;

		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		Socket clientSocket = new Socket("192.168.0.41", 10000);

		while (true) {
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			while (inFromServer.ready()) {
				System.out.println(inFromServer.readLine());
			}

			sentence = inFromUser.readLine();
			if (sentence.startsWith("ip=")) {
				try {
					clientSocket = new Socket(sentence.split(";")[0].split("=")[1], Integer.parseInt(sentence.split(";")[1]));
					System.out.println("IP set");
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Usage: ip=<ip>;<port>");
				}
				continue;
			}
			System.out.println("Send Command/Message: " + sentence);
			outToServer.writeBytes(" " + sentence + '\n');
			if (sentence.equals("exit")) {
				break;
			}

		}
		clientSocket.close();*/
	}

}