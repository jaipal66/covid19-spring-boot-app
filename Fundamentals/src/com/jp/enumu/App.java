package com.jp.enumu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {

	public static void main(String[] args) {

		Map<String, Player> playerMap = new HashMap<>();
		
		Player kohli=new Player(101,"Kohli",134);
		Player rahane=new Player(102,"Rahane",103);
		Player rahul=new Player(103,"Rahul",165);
		Player rohit=new Player(104,"Rohit",100);
		Player dhawan=new Player(105,"Dhawan",144);
		Player pandya=new Player(106,"Pandya",213);
		
		playerMap.put(kohli.getPlayerID()+"", kohli);
		playerMap.put(rahane.getPlayerID()+"", rahane);
		playerMap.put(rahul.getPlayerID()+"", rahul);
		playerMap.put(rohit.getPlayerID()+"", rohit);
		playerMap.put(dhawan.getPlayerID()+"", dhawan);
		playerMap.put(pandya.getPlayerID()+"", pandya);
		
		System.out.println(playerMap);
		
		List<Map.Entry<String, Player>> playerList=new ArrayList<>(playerMap.entrySet());
		System.out.println(playerList);
		Comparator<Map.Entry<String, Player>> sortByScore=new Comparator<Map.Entry<String, Player>>() {
			@Override
			public int compare(Map.Entry<String, Player> o1, Map.Entry<String, Player> o2) {
				Player first=o1.getValue();
				Player second=o2.getValue();
				return second.getScore()-first.getScore();
			}
		};
		System.out.println("+++++++++++++++++++++++++++++");
		Collections.sort(playerList,sortByScore);
		System.out.println(playerList);
		
		System.out.println("+++++++++++++++++++++++++++++");
		
		for (int i=0;i<3;i++) {
			System.out.println(playerList.get(i).getValue().getPlayerName());
		}
		System.out.println("+++++++++++++++++++++++++++++");
		System.out.println("+++++++++++++++++++++++++++++");

		Map<String, Integer> scores = new HashMap<>();

		scores.put("Kohli", 130);
		scores.put("Rahane", 135);
		scores.put("Rahul", 189);
		scores.put("Rohit", 78);
		scores.put("Dhawan", 210);
		scores.put("Pandya", 245);
		scores.put("Pandey", 55);

		for (Map.Entry<String, Integer> entry : scores.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

		System.out.println("+++++++++++++++++++++++++++++");

		List<Integer> list = new ArrayList<>(scores.values());

		Collections.sort(list);
		System.out.println(list);
		System.out.println("+++++++++++++++++++++++++++++");

		Comparator<Integer> com = new Comparator<Integer>() {
			@Override
			public int compare(Integer first, Integer second) {
				return second.compareTo(first);
			}
		};

		Collections.sort(list, com);
		System.out.println(list);

		System.out.println("+++++++++++++++++++++++++++++");

		List<Map.Entry<String, Integer>> entryList = new ArrayList<>(scores.entrySet());
		Comparator<Map.Entry<String, Integer>> entryComparator = new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> firstEntry, Map.Entry<String, Integer> secondEntry) {
				return secondEntry.getValue().compareTo(firstEntry.getValue());
			}
		};

		Collections.sort(entryList, entryComparator);

		System.out.println(entryList);
		System.out.println("+++++++++++++++++++++++++++++");
		List<String> playerNameList = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			playerNameList.add(entryList.get(i).getKey());
		}

		System.out.println(playerNameList);
	}
}
