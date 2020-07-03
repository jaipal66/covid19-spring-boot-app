package com.jp.enumu;

public class Player {

	
	private int playerID;
	private String playerName;
	private int score;
	
	
	public Player(int playerID, String playerName, int score) {
		this.playerID = playerID;
		this.playerName = playerName;
		this.score = score;
	}
	public int getPlayerID() {
		return playerID;
	}
	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
}
