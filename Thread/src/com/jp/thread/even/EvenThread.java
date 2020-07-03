package com.jp.thread.even;

public class EvenThread implements Runnable{

	private Printer printer;
	private int limit;

	EvenThread(Printer printer,int limit) {
		this.printer = printer;
		this.limit=limit;
	}

	@Override
	public void run() {
		printer.printEvenNumber(limit);
	}

}
