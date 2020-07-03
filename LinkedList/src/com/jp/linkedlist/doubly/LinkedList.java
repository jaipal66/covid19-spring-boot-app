package com.jp.linkedlist.doubly;

public class LinkedList<E> {

	private Node<E> first;
	private Node<E> last;

	public void removeLast() {
		Node<E> temp = last;
		if (last == null)
			throw new RuntimeException();
		removeLast(temp);
	}

	private E removeLast(Node<E> last) {
		E e = last.data;
		Node<E> prev = last.prev;
		last.data = null;
		last.prev = null;
		this.last = prev;

		if (prev == null)
			this.last = null;
		else
			prev.next = null;

		return e;
	}

	public void removeFirst() {
		Node<E> temp = first;
		if (temp == null)
			throw new RuntimeException();
		removeFirst(temp);
	}

	private E removeFirst(Node<E> first) {
		E d = first.data;
		Node<E> next = first.next;
		first.data = null;
		first.next = null;
		this.first = next;
		if (next == null)
			last = null;
		else
			next.prev = null;
		size--;
		return d;
	}

	private void linkFirst(E data) {
		final Node<E> temp = first;
		Node<E> node = new Node<>(null, data, temp);
		first = node;
		if (temp == null)
			last = node;
		else
			temp.prev = node;
		size++;

	}

	private void linkLast(E data) {
		final Node<E> temp = last;
		Node<E> node = new Node<>(temp, data, null);
		last = node;
		if (temp == null)
			first = node;
		else
			temp.next = node;
		size++;
	}

	public void add(E e) {
		linkLast(e);
	}

	public void addLast(E e) {
		linkLast(e);
	}

	public void offer(E e) {
		add(e);
	}

	public void addFirst(E e) {
		linkFirst(e);
	}

	public void push(E e) {
		addFirst(e);
	}

	private int size;

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	private static class Node<E> {

		private E data;
		private Node<E> prev;
		private Node<E> next;

		Node(Node<E> prev, E data, Node<E> next) {
			this.prev = prev;
			this.data = data;
			this.next = next;
		}
	}
}
