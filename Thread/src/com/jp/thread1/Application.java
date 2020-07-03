package com.jp.thread1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Application {

	public static void main(String[] args) {

		// int x=32;
		// System.out.println((x != 0) && ((x & (x - 1)) == 0));

		/*
		 * Task race=new Task("Task"); race.start();
		 * 
		 * race.dumpStack();
		 * 
		 * Task1 task1=new Task1(); Thread t=new Thread(task1,"Task1"); t.start();
		 */
		PrintNumber print = new PrintNumber();
		int number = 10;
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 100; i++) {
			Future<?> f = executorService.submit(new PrintNumberTask(print, number));
			try {
				number = (int) f.get();
				System.out.println("Retrun result " + number);
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		/*
		 * 
		 * Executor executor = Executors.newFixedThreadPool(10); for (int i = 0; i <
		 * 100; i++) executor.execute(new PrintNumberTaskR(print, 10));
		 * 
		 * ExecutorService executorService = Executors.newFixedThreadPool(10); for (int
		 * i = 0; i < 100; i++) executorService.submit(new PrintNumberTask(print, 10));
		 * 
		 * 
		 * 
		 * ExecutorService executorService1 = Executors.newCachedThreadPool(); for (int
		 * i = 0; i < 100; i++) executorService1.submit(new PrintNumberTask(print, 10));
		 * 
		 * ScheduledExecutorService scheduledExecutorService =
		 * Executors.newScheduledThreadPool(10); for (int i = 0; i < 100; i++)
		 * scheduledExecutorService.schedule(new PrintNumberTask(print, 10), 5,
		 * TimeUnit.SECONDS);
		 * 
		 * ScheduledExecutorService scheduledExecutorService1 =
		 * Executors.newScheduledThreadPool(10); for (int i = 0; i < 100; i++)
		 * scheduledExecutorService1.scheduleAtFixedRate(new PrintNumberTaskR(print,
		 * 10), 5,5, TimeUnit.SECONDS);
		 * 
		 * ScheduledExecutorService scheduledExecutorService2 =
		 * Executors.newScheduledThreadPool(10); for (int i = 0; i < 100; i++)
		 * scheduledExecutorService2.scheduleWithFixedDelay(new PrintNumberTaskR(print,
		 * 10),5, 5, TimeUnit.SECONDS);
		 * 
		 * 
		 * 
		 * //executor.shutdown();
		 */

	}

	public static int distance(Point p1, Point p2) {

		int x1 = square(p1.x - p2.x);
		int y1 = square(p1.y - p2.y);

		return x1 + y1;
	}

	static int square(int x) {
		return x * x;
	}

	class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void permute(String value, String ans) {
		if (value.length() == 0) {
			System.out.println(ans + " ");
			return;
		}
		for (int i = 0; i < value.length(); i++) {
			char ch = value.charAt(i);
			String row = value.substring(0, i) + value.substring(i + 1);
			permute(row, ans + ch);
		}
	}
}

class PrintNumberTask implements Callable<Integer> {

	private PrintNumber printeNumber;
	private int length;

	PrintNumberTask(PrintNumber printeNumber, int length) {
		this.printeNumber = printeNumber;
		this.length = length;
	}

	@Override
	public Integer call() {
		return printeNumber.print(length);
		
	}
}

class PrintNumber {
	public synchronized Integer print(int length) {
		int i = length;
		for (i = length; i < length; i++)
			System.out
					.println(Thread.currentThread().getName() + " : " + Thread.currentThread().getState() + " : " + i);
		return i;
	}
}

class PrintNumberTaskR implements Runnable {

	private PrintNumber printeNumber;
	private int length;

	PrintNumberTaskR(PrintNumber printeNumber, int length) {
		this.printeNumber = printeNumber;
		this.length = length;
	}

	@Override
	public void run() {
		printeNumber.print(length);
	}
}
