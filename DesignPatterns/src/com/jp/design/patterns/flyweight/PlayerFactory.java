package com.jp.design.patterns.flyweight;

import java.util.HashMap;
import java.util.Map;

public class PlayerFactory {

	public static Player getPlayer(PlayerType playerType) {
		Map<String, Player> players = new HashMap();
		if (players.containsKey(playerType.toString())) {
			return players.get(playerType.toString());
		}
		Player player = null;
		switch (playerType) {
		case TERRORIST:
			player = new Terrorist();
			break;
		case FORCE:
			player = new Force();
			break;
		default:
			break;
		}
		players.put(playerType.toString(), player);
		return player;
	}
}
