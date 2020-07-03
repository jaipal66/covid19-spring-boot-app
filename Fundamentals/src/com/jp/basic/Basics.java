package com.jp.basic;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Basics {

	public static void main(String[] args) {

		char a = 'a';
		char b = 'b';
		char c = 'c';
		char d = 'd';
		char e = 'e';
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put(b, 1);
		map.put(c, 3);
		map.put(d, 5);
		map.put(e, 2);
		map.put(a, 5);

		System.out.println(map);
		int maxValue = 0;
		char key='\0';
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (maxValue<entry.getValue()) {
				maxValue = entry.getValue();
				key=entry.getKey();
			}
		}
		System.out.println(key+":"+maxValue );
	}

}

class keyComparator implements Comparator<Character> {

	@Override
	public int compare(Character c1, Character c2) {
		if (c1 == c2)
			return 0;
		else if (c1 < c2)
			return 1;
		else
			return -1;
	}
}