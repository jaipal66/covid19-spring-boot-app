package com.jp.multiple.client.interaction;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	
	private static final int PORT = 9090;
	private static String[] names = { "jaipal", "kumar", "jp" };
	private static String[] adjectives = { "the gentle", "the un-gentle", "the unbane" };
	private static ArrayList<ClientHandler> clients = new ArrayList<ClientHandler>();
	private static ExecutorService excExecutorService = Executors.newFixedThreadPool(5);

	public static void main(String[] args) throws IOException {

		ServerSocket listener = new ServerSocket(PORT);
		while (true) {
			System.out.println("[SERVER] is waiting for client connection...");
			Socket client = listener.accept();
			System.out.println("[SERVER] connected to client");
			ClientHandler clientHandler = new ClientHandler(client, clients);
			clients.add(clientHandler);
			excExecutorService.execute(clientHandler);

		}

	}

	public static String getRandomName() {

		String name = names[(int) Math.random() * names.length];
		String adj = adjectives[(int) Math.random() * adjectives.length];
		return name + " > " + adj;
	}
}
