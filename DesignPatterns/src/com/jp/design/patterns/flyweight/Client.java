package com.jp.design.patterns.flyweight;

public class Client {

	public static void main(String[] args) {

		String[] players = { PlayerType.TERRORIST.toString(), PlayerType.FORCE.toString() };

		String[] weapons = { "AK-47", "Desert Egale" };

		Player player = PlayerFactory.getPlayer(PlayerType.FORCE);
		player.assignWeapon("AK-47");
		player.mission();
	}
}
