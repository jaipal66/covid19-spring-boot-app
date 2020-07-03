package com.jp.custom.thread.pool;

import java.io.IOException;
import java.nio.CharBuffer;

public class CustomThreadPoolTest {

	public static void main(String[] args) throws InterruptedException {
		CustomThreadPool threadPool = new CustomThreadPool(5);
		for(int i=0;i<10;i++) {
		threadPool.execute(new Task());
		}
		//threadPool.shutdown();
		
	}
}
class Task implements Runnable{

	@Override
	public void run() {
		try {
			int i=0;
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " is executing task."+i++);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
}