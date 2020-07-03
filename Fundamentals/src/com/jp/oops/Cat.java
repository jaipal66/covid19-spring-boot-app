package com.jp.oops;

public class Cat extends Animal {

	public void soundMaking() {
		System.out.println("soundMaking from Cat");

	}
	
	@Override
	public void eat() {
		System.out.println("eat from Cat");
	}
	 @Override
	public void run() {
		System.out.println("run from Cat");
	}
}
