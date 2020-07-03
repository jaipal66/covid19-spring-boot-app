package com.jp.string;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Client {

	public static void main(String[] args) {

		List<String> list = new LinkedList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");

	}

	public static boolean checkPowerOfTwo(int n) {
		if (n == 0)
			return false;
		while (n > 1) {
			if (n % 2 != 0)
				return false;
			n = n / 2;
		}
		return true;
	}

	protected void finalize() throws Throwable {
		System.out.println("finalize : " + this.hashCode());
		System.out.println(10 / 0);
	}

	public static Client main(Client c1) {
		System.out.println("Before: " + c1.hashCode());
		c1 = new Client();
		System.out.println("After: " + c1.hashCode());
		return c1;
	}

	public static void main(List<String> list) {
		list = null;
	}
}
