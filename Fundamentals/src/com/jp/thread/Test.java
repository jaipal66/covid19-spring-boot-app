package com.jp.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {

	public static void main(String[] args) {
		
		Thread1 th=new Thread1();
		th.start();
		

		// ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor)
		// Executors.newScheduledThreadPool(5);
		// executor.scheduleWithFixedDelay(new Task(), 1, 10, TimeUnit.SECONDS);

		Printer printer = new Printer();
		/*
		 * DocumentPrinter printer1 = new DocumentPrinter("printer1", printer, 10);
		 * printer1.start(); DocumentPrinter printer2 = new DocumentPrinter("printer2",
		 * printer, 10); printer2.start();
		 */

		/*
		 * ExecutorService execute = Executors.newFixedThreadPool(10); for(int
		 * i=0;i<15;i++) { execute.execute(new DocumentPrinter("printer1", printer, 1));
		 * }
		 */

		/*ScheduledExecutorService execute = Executors.newScheduledThreadPool(10);

		for (int i = 0; i < 15; i++) {
			Future<Integer> f = execute.schedule(new DocumentPrinter("printer1", printer, 10), 1, TimeUnit.SECONDS);

			 System.out.println(f.isCancelled());
			 System.out.println(f.isDone());
			 try {
				System.out.println(f.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 System.out.println(f.cancel(true));
		}
       */
	}
}

class DocumentPrinter implements Callable<Integer> {
	Printer printer;
	int numberOfCopy;

	DocumentPrinter(String printer1, Printer printer, int numberOfCopy) {
		Thread.currentThread().setName(printer1);
		this.printer = printer;
		this.numberOfCopy = numberOfCopy;
	}

	@Override

	public Integer call() {
		System.out.println("==DocumentPrinter started ");
		printer.printDocuments(numberOfCopy, Thread.currentThread().getName());
		System.out.println("==DocumentPrinter fininish ");
		return 1;
	}
	/*
	 * @Override public void run() {
	 * System.out.println("==DocumentPrinter started ");
	 * printer.printDocuments(numberOfCopy, Thread.currentThread().getName());
	 * System.out.println("==DocumentPrinter fininish ");
	 * 
	 * }
	 */
}

class Printer {
	public void printDocuments(int numberOfCopy, String name) {
		synchronized (this) {
			for (int document = 0; document < numberOfCopy; document++)
				System.out.println(name + " Printing Documnet : " + document);
		}
	}
}
class Thread1 extends Thread{
	
}
class Task implements Runnable {
	@Override
	public void run() {
		System.out.println("Runnable Task");
	}
}
