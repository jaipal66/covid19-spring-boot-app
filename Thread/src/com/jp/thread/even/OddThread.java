package com.jp.thread.even;

public class OddThread implements Runnable{
	
	private Printer printer;
	private int limit;
	
	OddThread(Printer printer,int limit){
		this.printer=printer;
		this.limit=limit;
	}

	@Override
	public void run() {
		printer.printOddNumber(limit);
	}

	
}
