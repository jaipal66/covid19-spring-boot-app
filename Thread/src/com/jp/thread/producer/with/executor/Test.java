package com.jp.thread.producer.with.executor;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Test {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		NumberGenerator number = new NumberGenerator(queue);

		/*Thread producer = new Thread(new Producer(number), "Producer");
		Thread consumer = new Thread(new Consumer(number), "Consumer");

		producer.start();
		consumer.start();*/

		Executor executor = Executors.newCachedThreadPool();
		executor.execute(new Producer(number));
		executor.execute(new Consumer(number));

		/*
		 ExecutorService executorService =Executors.newFixedThreadPool(2);
		 executorService.execute(new Producer(number)); executorService.execute(new
		 Consumer(number));
		 

		
		  ExecutorService executorService2 = Executors.newFixedThreadPool(2); Future<?>
		  f1 = executorService2.submit(new Producer(number)); Future<?> f2 =
		  executorService2.submit(new Consumer(number));
		  
		  try { Object ob = f1.get(); Object ob2 = f2.get(1, TimeUnit.SECONDS); boolean
		  b=f1.isCancelled(); boolean done=f1.isDone(); boolean cancel=f2.cancel(true);
		  
		  } catch (InterruptedException | ExecutionException | TimeoutException e) { 
		  e.printStackTrace(); 
		  }
		 

		
		  ScheduledExecutorService
		  scheduledExecutorService=Executors.newScheduledThreadPool(2);
		  scheduledExecutorService.schedule(new Producer(number), 1, TimeUnit.SECONDS);
		  scheduledExecutorService.schedule(new Consumer(number), 1, TimeUnit.SECONDS)
		 ;

		
		  ScheduledExecutorService
		  scheduledExecutorService2=Executors.newScheduledThreadPool(2);
		  scheduledExecutorService2.scheduleAtFixedRate(new Producer(number), 1, 5,
		  TimeUnit.SECONDS); scheduledExecutorService2.scheduleAtFixedRate(new
		  Consumer(number), 1,5, TimeUnit.SECONDS);
		 

		ScheduledExecutorService scheduledExecutorService3 = Executors.newScheduledThreadPool(2);
		ScheduledFuture<?> scheduledFuture1 = scheduledExecutorService3.scheduleWithFixedDelay(new Producer(number), 1,
				5, TimeUnit.SECONDS);
		ScheduledFuture<?> scheduledFuture2 = scheduledExecutorService3.scheduleWithFixedDelay(new Consumer(number), 1,
				5, TimeUnit.SECONDS);*/

	}
}
