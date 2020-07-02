package com.jp.multiple.client.interaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable {

	private Socket client;
	private BufferedReader in;
	private PrintWriter out;
	private ArrayList<ClientHandler> clients;

	ClientHandler(Socket client, ArrayList<ClientHandler> clients) throws IOException {
		this.client = client;
		this.clients = clients;
		this.in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		this.out = new PrintWriter(client.getOutputStream(), true);

	}

	@Override
	public void run() {
		try {
			while (true) {
				String request = in.readLine();
				if (request.contains("name")) {
					out.println(Server.getRandomName());
				} else if (request.startsWith("say")) {
					int firstSpace = request.indexOf(" ");
					if (firstSpace != -1) {
						sayToAll(request.substring(firstSpace + 1));
					}
				} else
					out.println(" Type tell me a name to get random name");
			}
		} catch (IOException e) {
			System.err.println("IO Exception in Cleint Handler");
			System.err.println(e.getStackTrace());
		} finally {
			try {
				client.close();
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private void sayToAll(String message) {

		for (ClientHandler clientHandler : clients) {
			clientHandler.out.println(message);
		}
	}

}
