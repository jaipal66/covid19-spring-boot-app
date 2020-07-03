package com.jp.thread.even;

public class AppTest {

	public static void main(String[] args) {
		
		Printer printer=new Printer();
		Thread even=new Thread(new EvenThread(printer, 20),"EvenThread");
		Thread odd=new Thread(new OddThread(printer, 20),"OddThread");
		
		even.start();
		odd.start();
		
	}
}
