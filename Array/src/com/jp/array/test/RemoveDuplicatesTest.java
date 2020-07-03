package com.jp.array.test;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class RemoveDuplicatesTest {

	@Test
	public void testArrayWithDuplicates() {
		Integer[] given = {1, 2, 3, 3 };
		Integer[] actual = RemoveDuplicates.removeDuplicates(given);
		Integer[] expected = new Integer[] { 1, 2, 3 };
		assertArrayEquals(expected, actual);
	}

	@Test
	public void testArrayWithoutDuplicates() {
		Integer[] given = new Integer[] { 1, 2, 3 };
		Integer[] actual = RemoveDuplicates.removeDuplicates(given);
		Integer[] expected = new Integer[] { 1, 2, 3 };
		assertArrayEquals(expected, actual);
	}

	@Test
	public void testWithEmptyArray() {
		Integer[] given = new Integer[] {};
		Integer[] actual =RemoveDuplicates.removeDuplicates(given);
		Integer[] expected = new Integer[] {};
		assertArrayEquals(expected, actual);
	}

	@Test
	public void testWithNull() {
		Integer[] given = null;
		Integer[] actual = RemoveDuplicates.removeDuplicates(given);
		Integer[] expected = null;
		assertArrayEquals(expected, actual);
	}

	@Test
	public void testArrayWithAllDuplicates() {
		Integer[] given = new Integer[] { 3, 3, 3 };
		Integer[] actual = RemoveDuplicates.removeDuplicates(given);
		Integer[] expected = new Integer[] { 3 };
		assertArrayEquals(expected, actual);
	}

	@Test
	public void testArrayWithMultipleDuplicates() {
		Integer[] given = new Integer[] { 1, 2, 3, 3, 4, 4, 5, 5, 5 };
		Integer[] actual = RemoveDuplicates.removeDuplicates(given);
		Integer[] expected = new Integer[] { 1, 2, 3, 4, 5 };
		assertArrayEquals(expected, actual);
	}

}
