package com.jp.basic;

import java.util.Arrays;

public class ArrayList<E> {

	private static final int DEFAULT_CAPCITY = 10;
	private Object[] DEFAULT_CAPACITY_EMPTY_ARRAY = {};
	private Object[] data;
	private int size;
	private int modCount = 0;

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public boolean contains(E element) {
		return indexOf(element) < 0;
	}

	private int indexOf(E element) {
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (data[i] == element)
					return i;
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (element.equals(data[i]))
					return i;
			}
		}
		return -1;
	}

	public E get(int index) {
		rangeCheck(index);
		return (E) data[index];
	}

	public boolean add(E element) {
		insureCapacity(size + 1);
		data[size++] = element;
		return true;
	}

	public E set(E element, int index) {
		rangeCheck(index);
		E oldElement = (E) data[index];
		data[index] = element;
		return oldElement;
	}

	private void rangeCheck(int index) {
		if (index < 0) {
			throw new IllegalArgumentException("Index can't be " + index);
		} else if (index > data.length) {
			throw new IllegalArgumentException("Index can't be " + index);
		}
	}

	private void insureCapacity(int minimumCapacity) {
		int size = calculateCapacity(data, minimumCapacity);
		modCount++;
		if (size - data.length > 0)
			growArray(minimumCapacity);
	}

	private int calculateCapacity(Object[] data, int minimum) {
		if (data == DEFAULT_CAPACITY_EMPTY_ARRAY)
			return Math.max(DEFAULT_CAPCITY, minimum);
		return minimum;
	}

	private void growArray(int minimumCapacity) {
		int oldCapacity = data.length;
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		data = Arrays.copyOf(data, newCapacity);
	}

	public ArrayList() {
		this.data = DEFAULT_CAPACITY_EMPTY_ARRAY;
	}

	public ArrayList(int capacity) {
		if (capacity < 0)
			throw new IllegalArgumentException("");
		this.data = new Object[capacity];
	}

}
