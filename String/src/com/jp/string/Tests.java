package com.jp.string;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Tests {

	public static void main(String[] args) {

		
		/*MyHashMap map=new MyHashMap();
		map.put(1,"jaipal");
		map.put(2,"pk");
		map.put(3,"kl");
		map.put(1,"jp");
		
		System.out.println(map.get(2));*/
		
		Scanner sc=new Scanner(System.in);
		int nbr=sc.nextInt();
		String first=sc.nextLine();
		String second=sc.next();
		char ch=sc.nextLine().charAt(0);
		//int ind=sc.nextInt();
		
		System.out.println(nbr);
		System.out.println(first);
		System.out.println(second);
		System.out.println(ch);
		//System.out.println(ind);
		
		
		
	}

}

class MyHashMap {

	List<Node> head;

	public MyHashMap() {
		head = new LinkedList<>();
	}

	public boolean put(Object key, Object value) {
		for (int i = 0; i < head.size(); i++) {
			if (key == head.get(i).key) {
				head.remove(i);
			}
		}
		head.add(new Node(key, value));
		return true;
	}

	public Object get(Object key) {
		Object value = null;
		for (int i = 0; i < head.size(); i++) {
			if (key == head.get(i).key) {
				value = head.get(i).value;
			}
		}
		return value;
	}

	static class Node {
		Object key;
		Object value;

		Node(Object key, Object value) {
			this.key = key;
			this.value = value;
		}
	}
}
