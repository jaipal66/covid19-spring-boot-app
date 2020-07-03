package com.jp.oops;

public class Dog extends Animal {

	static {
		System.out.println("static block Dog");
	}
	{
		System.out.println("Instance block Dog");
	}

	static {
		System.out.println("second static block Dog");
	}
	{
		System.out.println("second instance block Dog");
	}

	Dog() {
		super();
		System.out.println("DC of Dog"+a);
	}

	public void bark() {
		System.out.println("bark from Dog");
	}

	@Override
	public void eat() {
		System.out.println("eat from Dog");
	}

	@Override
	public void run() {
		System.out.println("run from Dog");
	}
	

}
