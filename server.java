import java.io.*;
import java.net.*;
public class server{
public static void main(String args[]){
	try{
	ServerSocket serverSocket = new ServerSocket(9999);
	System.out.println("Server started. Waiting for clients...");
	while(true){
	Socket clientSocket =serverSocket.accept();
	System.out.println("Client connected: "+clientSocket);
	BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
	String message;
	while((message = in.readLine())!=null)
	{
	System.out.println("Received from client:" + message);
	out.println("Server recived:"+message);
	}
	System.out.println("Client disconnected:"+clientSocket);
	clientSocket.close();
	}
	}
	catch(IOException e){
	e.printStackTrace();
	}}}
