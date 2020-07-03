package com.jp.card.game;

public class Game {

	public Player getWinner() {
		return null;
	}

	public void play() {
		Deck deck = new Deck();
		System.out.println(deck);

		System.out.println(deck.deal());
		deck.shuffle(5);
		System.out.println(deck);

		Player rk = new Player();
		Player jp = new Player();
		Player pk = new Player();
		Player kp = new Player();
	}
}
