package com.jp.java8.hashmap;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		HashMap map=new HashMap();
		map.put(1, "ONE");
		map.put(2, "TWO");
		map.put(1, "Three");
		System.out.println(map.get(2));
		
		
	}
}

class HashMap{
	
	private List<Node> list=new ArrayList<>();
	
	public boolean put(Object key,Object value) {
		
		Node newNode=new Node(key,value);
		for(int i=0;i<list.size();i++) {
			Node temp=list.get(i);
			if(temp.getKey().equals(key)) {
				list.remove(temp);
			}
		}
		
		list.add(newNode);
		return false;
	}
	public Object get(Object key) {
       
		for(int i=0;i<list.size();i++) {
			Node temp=list.get(i);
			if(temp.getKey().equals(key))
				return temp.getValue();
		}
		return null;
	}
	
	
	
	private static class Node{
		private Object key;
		private Object value;
		Node(Object key,Object value){
			this.key=key;
			this.value=value;
		}
		
		public Object getKey() {
			return key;
		}
		public Object getValue() {
			return value;
		}
		
		public String toString() {
			return key+" : "+value;
		}
	}
}