package com.jp.multiinteraction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {
	private static final int PORT = 9090;
	private static String[] names = { "jaipal", "kumar", "jp" };
	private static String[] adjectives = { "the gentle", "the un-gentle", "the unbane" };

	public static void main(String[] args) throws IOException {

		ServerSocket listener = new ServerSocket(PORT);
		System.out.println("[SERVER] is waiting for client connection...");
		Socket client = listener.accept();
		System.out.println("[SERVER] connected to client");

		PrintWriter out = new PrintWriter(client.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		try {
			while (true) {
				String request = in.readLine();
				if (request.contains("name")) {
					out.println(getRandomName());
				} else
					out.println(" Type tell me a name to get random name");
			}
		} finally {
			client.close();
			listener.close();
		}
	}

	private static String getRandomName() {

		String name = names[(int) Math.random() * names.length];
		String adj = adjectives[(int) Math.random() * adjectives.length];
		return name + " > " + adj;
	}
}
