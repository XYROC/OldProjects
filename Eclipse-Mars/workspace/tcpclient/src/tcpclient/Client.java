package tcpclient;

import java.io.*;
import java.net.*;

public class Client {
	
	public static void main(String[] args) throws IOException {
		System.out.println("#############");
		System.out.println("#TCP Client##");
		System.out.println("#############");
		String sentence;
		
		BufferedReader inFromUser =
				new BufferedReader(
						new InputStreamReader(System.in));
		Socket clientSocket = new Socket("localhost", 25565);
		DataOutputStream outToServer =
				new DataOutputStream(
						clientSocket.getOutputStream());
		
		BufferedReader inFromServer =
				new BufferedReader(
						new InputStreamReader(clientSocket.getInputStream()));
		while(true){
			if(inFromServer.ready()){
				System.out.println(">>"+inFromServer.readLine());
			}
			sentence = inFromUser.readLine();
			//System.out.println("Sent Command/Message: "+sentence);	
			if(sentence.equals("exit")){
				break;
			}
			outToServer.writeBytes(sentence+'\n');
		}
		clientSocket.close();
	}

}
