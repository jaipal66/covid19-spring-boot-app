package com.jp.thread.producer.with.executor;

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
