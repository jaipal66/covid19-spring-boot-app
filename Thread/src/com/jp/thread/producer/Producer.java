package com.jp.thread.producer;

public class Producer implements Runnable{
	
	private NumberGenerator numberGenerator;
	
	Producer(NumberGenerator numberGenerator){
		this.numberGenerator=numberGenerator;
	}

	@Override
	public void run() {
		
		numberGenerator.produceNumber();
	}
	
	

}
