package com.jp.card.game;

import java.util.List;

public class Player {
	
	private int playedID;
	private String name;
	private List<Card> cards;
	
	public int getPlayedID() {
		return playedID;
	}
	public void setPlayedID(int playedID) {
		this.playedID = playedID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Card> getCards() {
		return cards;
	}
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
}
