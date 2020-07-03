package com.jp.linked.list;

public class DoubleLinkedList<E> {

	private Node<E> head;
	private Node<E> tail;

	public int size() {
		return 0;
	}

	public E addFirst(E data) {
		Node newNode = new Node(null, data, null);
		return data;
	}

	static class Node<E> {
		Node<E> prev;
		E data;
		Node<E> next;

		Node(Node<E> prev, E data, Node<E> next) {
			this.prev = prev;
			this.data = data;
			this.next = next;
		}
	}
}
