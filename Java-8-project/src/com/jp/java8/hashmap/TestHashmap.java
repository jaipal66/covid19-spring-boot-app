package com.jp.java8.hashmap;

public class TestHashmap {

	public static void main(String[] args) {
		HashMap2<String, Integer> map = new HashMap2<>();

		map.put("ONE", 1);
		map.put("TWO", 2);
		map.put("THREE", 3);
		map.put("ONE", 4);
		System.out.println(map.size());
		System.out.println(map);
		System.out.println(map.get("ONE"));
	}
}

class HashMap2<K, V> {

	private int size;
	private static final int SIZE = 16;

	private Node<K, V> nodes[];

	public HashMap2() {
		this.nodes = new Node[SIZE];
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	private int hash(K key) {
		if (key == null)
			return 0;
		return key.hashCode();
	}

	private int tableIndex(int hash) {
		return hash % this.nodes.length - 1;
	}

	public V put(K key, V value) {
		int hash = hash(key);
		int index = tableIndex(hash);
		Node<K, V> newNode = new Node<>(key, value, hash, null);
		Node<K, V> temp = this.nodes[index];
		if (temp == null) {
			this.nodes[index] = newNode;
			size++;
		} else {
			while (temp.next != null) {
				if (temp.getKey().equals(key)) {
					temp.value = value;
					break;
				}
				temp = temp.next;
			}
			if (temp.key.equals(key))
				temp.value = value;
			else
				temp.next = newNode;
			size++;
		}
		return null;
	}

	public V get(K key) {
		if (key == null) {
			Node<K, V> temp = this.nodes[0];
			if (temp == null)
				return null;
			else {
				while (temp.next != null) {
					if (temp.getKey() == null)
						return temp.getValue();
					temp = temp.next;
				}
			}
		} else {
			int hash = hash(key);
			int index = tableIndex(hash);
			Node<K, V> temp = this.nodes[index];
			if (temp == null)
				return null;
			else {
				while (temp.next != null) {
					if (temp.getKey().equals(key))
						return temp.getValue();
					temp = temp.next;
				}
				return temp.getValue();
			}
		}
		return null;
	}

	public String toString() {
		String result = "{ ";
		Node<K, V> temp[] = this.nodes;
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != null)
				result += temp[i].getKey() + ":" + temp[i].getValue()+" ";
		}
		result += "}";
		return result;
	}

	private static class Node<K, V> {
		private final K key;
		private V value;
		private final int hash;
		private Node<K, V> next;

		public Node(K key, V value, int hash, Node<K, V> next) {
			this.key = key;
			this.value = value;
			this.hash = hash;
			this.next = next;
		}

		public final K getKey() {
			return key;
		}

		public final V getValue() {
			return value;
		}

		public String toString() {
			return key + "=" + value;
		}

	}
}