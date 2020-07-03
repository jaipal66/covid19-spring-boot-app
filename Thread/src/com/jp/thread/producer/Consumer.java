package com.jp.thread.producer;

public class Consumer implements Runnable {

	private NumberGenerator numberGenerator;

	Consumer(NumberGenerator numberGenerator) {
		this.numberGenerator = numberGenerator;
	}

	@Override
	public void run() {

		numberGenerator.consumeNumber();
	}
}
