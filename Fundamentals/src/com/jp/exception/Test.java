package com.jp.exception;

public class Test {
	public static void main(String[] args) {
		Printer printer = new Printer();

		try {
			System.out.println("try");
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.println(e);
		} catch (RuntimeException e) {

		}

		finally {
			System.out.println("finally");
		}
	}
}

class Printer {

	public void print() throws Exception1 {
		if (true) {
			throw new Exception1("Exception1");

		}
	}

	public void print2() {
		if (true) {
			throw new Exception2("Exception2");

		}
	}
}