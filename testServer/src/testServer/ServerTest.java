package testServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {
	public static void main(String[] args) throws IOException{
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		
		serverSocket = new ServerSocket(9193);
		
		try {
			clientSocket = serverSocket.accept();
			System.out.println("Client connect");
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			while (true) {
				String inputLine = null;
				inputLine = in.readLine();
				System.out.println("From client : " + inputLine);
				out.println(inputLine);
				if (inputLine.equals("quit"))
					break;
			}
			out.close();
			in.close();
			clientSocket.close();
			serverSocket.close();
			} catch (Exception e){
				e.printStackTrace();
		}
	}

}
