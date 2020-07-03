package com.jp.thread.producer;

import java.util.LinkedList;
import java.util.Queue;

public class Test {

	public static void main(String[] args) {
		Queue<Integer> queue=new LinkedList<>();
		NumberGenerator number=new NumberGenerator(queue);
		
		Thread producer=new Thread(new Producer(number),"Producer");
		Thread consumer=new Thread(new Consumer(number),"Consumer");
		
		producer.start();
		consumer.start();
		
		
		
	}
}
