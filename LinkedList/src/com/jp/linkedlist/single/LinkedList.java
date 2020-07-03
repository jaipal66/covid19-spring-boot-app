package com.jp.linkedlist.single;

public class LinkedList<E> {

	private Node<E> head;

	public E findMiddle() {
		return findMiddle(head);
	}

	/*
	 * 
	 * Method 1: Steps: 1.Take two pointer both initially points to the head of
	 * LinkedList 2.move one pointer by one step 3.and another pointer by two steps
	 * 4.when fast pointer reach to the end of List then slow pointer will point to
	 * Middle element
	 * 
	 * 
	 */
	public E findMiddle(Node<E> head) {
		Node<E> p = head;
		Node<E> q = head;
		while (p.next != null) {
			p = p.next.next;
			q = q.next;
		}
		return q.data;
	}

	/*
	 * Method 2:
	 * 
	 * Steps: 1.take one count variable and one middle as temp node 2.move middle to
	 * next only when count is odd
	 * 
	 * 
	 */
	public E findMiddle2(Node<E> head) {
		Node<E> middle = head;
		Node<E> temp = head;
		int count = 0;
		while (temp != null) {
			if (count % 2 != 0) {
				middle = middle.next;
			}
			temp = temp.next;
			count++;
		}
		return middle.data;
	}

	/*
	 * Method 3: Steps: 1.find length of LinkedList 2.then traverse till length/2
	 * 
	 * 
	 * 
	 */
	public E findMiddle3(Node<E> head) {
		int length = 0;
		Node<E> temp = head;
		while (temp != null) {
			temp = temp.next;
			length++;
		}
		int i = 0;
		temp = head;
		while (i < length / 2) {
			i++;
			temp = temp.next;
		}
		return temp.data;
	}

	public E findNthFromLast(int nth) {
		return findNthFromLast(head, nth);
	}

	private E findNthFromLast(Node<E> head, int nth) {
		Node<E> temp = head;
		int cnt = 0;
		while (cnt < nth) {
			temp = temp.next;
			cnt++;
		}
		Node<E> p = head;
		while (temp != null) {
			p = p.next;
			temp = temp.next;
		}
		return p.data;
	}

	public Node<E> revrseWithRecurssion() {
		head = revrseByRecurrsion(head);
		return head;
	}

	private Node<E> revrseByRecurrsion(Node<E> head) {
		Node<E> p = head;
		Node<E> q = head.next;
		if (p == null || q == null)
			return p;
		q = revrseByRecurrsion(q);
		p.next.next = p;
		p.next = null;
		return q;
	}

	public Node<E> reverse() {
		head = reverse(head);
		return head;
	}

	/*
	 * 
	 * Steps: 1.take currentNode prevNode and nextNode as temp variable 2.make
	 * currentNode as head 3.traverse till end of list i.e currentNode is not null
	 * 4. while traversing do the followings 1.assign currentNode next reference to
	 * nextNode 2.assign prevNode reference to currentNode next 3.Move prevNode i.e
	 * make prevNode as currentNode 4.Move currentNode to nextNode
	 *
	 * 5.return prevNode now this will be the head of reversed LinkedList
	 *
	 */
	private Node<E> reverse(Node<E> head) {
		Node<E> current_node = head;
		Node<E> next_node = null;
		Node<E> prev_node = null;
		while (current_node != null) {
			next_node = current_node.next;
			current_node.next = prev_node;
			prev_node = current_node;
			current_node = next_node;
		}
		return prev_node;
	}

	public void delete(E data) {
		if (head == null)
			System.out.println("Linked List does not exit");
		Node<E> p = head.next;
		Node<E> q = head;
		if (q.data == data) {
			head = p;
			q = null;
		} else {
			while (p != null && p.data != data) {
				p = p.next;
				q = q.next;
			}
			if (p.next == null) {
				q.next = null;
				p = null;
			} else {
				q.next = p.next;
				p = null;
			}
		}

	}

	public void addAtFront(E data) {
		Node<E> node = new Node<>(data);
		if (head == null) {
			head = node;
			head.next = null;
		} else {
			node.next = head;
			head = node;
		}
	}

	public void addAt(E data, int index) {
		Node<E> node = new Node<E>(data);
		if (head == null) {

		} else {
			Node<E> temp = head;
			int cnt = 1;
			while (cnt < index) {
				temp = temp.next;
				cnt++;
			}
			node.next = temp.next;
			temp.next = node;
		}
	}

	public void addAtLast(E data) {
		Node<E> node = new Node<E>(data);
		if (head == null) {
			head = node;
			head.next = null;
		} else {
			Node<E> temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
			node.next = null;
		}
	}

	public void printLinkedList() {
		Node<E> temp = head;
		while (temp != null) {
			System.out.print(temp.data + (temp.next != null ? "->" : ""));
			temp = temp.next;
		}
	}

	private static class Node<E> {
		E data;
		Node<E> next;

		Node(E data) {
			this.data = data;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		LinkedList<Character> list = new LinkedList<>();
		list.addAtLast('a');
		list.addAtLast('b');
		list.addAtLast('c');
		list.addAtLast('d');
		list.addAtLast('e');
		list.addAtLast('f');
		list.addAtFront('g');
		list.addAt('h', 3);
		list.printLinkedList();
		System.out.println('\n');
		LinkedList<Integer> list1 = new LinkedList<>();
		list1.addAtLast(1);
		list1.addAtLast(2);
		list1.addAtLast(3);
		list1.addAtLast(4);
		list1.addAtLast(5);
		list1.addAtLast(6);
		list1.addAtFront(7);
		list1.addAt(8, 3);
		list1.printLinkedList();
		list1.delete(6);
		System.out.println('\n');
		list1.printLinkedList();
		list1.reverse();
		System.out.println('\n');
		list1.printLinkedList();
		System.out.println('\n');
		System.out.println(list1.findMiddle());
		System.out.println(list1.findNthFromLast(2));
	}
}
