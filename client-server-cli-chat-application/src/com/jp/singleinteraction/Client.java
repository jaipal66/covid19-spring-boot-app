package com.jp.singleinteraction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class Client {

	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 9090;

	public static void main(String[] args) throws UnknownHostException, IOException {

		Socket socket = new Socket(SERVER_IP, SERVER_PORT);
		BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String serverResponse = input.readLine();
		JOptionPane.showMessageDialog(null, serverResponse);

		socket.close();
	}
}
