package main.ch14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

public class TestSocket {
	
	private static int  IP_PORT = 9090;
	private static String  IP_HOST = "127.0.0.1";
	
	
	@Test
	public void testClientSocket() throws IOException {
		
		// create socket to connect server
		InetAddress inetAddress = InetAddress.getByName(IP_HOST);
		Socket socket = new Socket(inetAddress,IP_PORT);
		
		// create inputsreadm from socket
		InputStream is = socket.getInputStream();
		
		//read data and output
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader bufferedReader = new BufferedReader(isr);
		System.out.println(bufferedReader.readLine());
		
		// close resource
		bufferedReader.close();
		isr.close();
		is.close();
		socket.close();
		
		
	}
	

	@Test
	public void testServerSocket() throws IOException {
		
		// create server socket object
		ServerSocket serverSocket = new ServerSocket(IP_PORT);
		Socket socket = serverSocket.accept();
		
		// create outputstream and printwriter
		OutputStream os = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(os);
		pw.write(" \"hello\" from server "+socket.getInetAddress().toString());
		
		
		// close resource
		pw.close();
		os.close();
		socket.close();
		serverSocket.close();
		
	}

}
