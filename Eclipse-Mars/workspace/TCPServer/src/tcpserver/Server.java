package tcpserver;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws Throwable {
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		ServerSocket socket = new ServerSocket(25565);
		System.out.println("Server up. Waiting for connection...");
		socket.setSoTimeout(600000);
		Socket accepted = socket.accept();
		System.out.println("Connection from " + accepted.getInetAddress().getHostAddress());
		InputStream input = accepted.getInputStream();
		DataOutputStream output = new DataOutputStream(accepted.getOutputStream());
		BufferedReader in = new BufferedReader(new InputStreamReader(input));
		while (true) {
			if (in.ready()) {
				System.out.println(">>" + in.readLine());
			}
			String userInput = inFromUser.readLine();
			if (userInput.equalsIgnoreCase("exit"))
				break;
			output.writeBytes(userInput);
		}
		in.close();
		output.close();
		socket.close();
	}

}
