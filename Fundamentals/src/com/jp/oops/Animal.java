package com.jp.oops;

public class Animal {

	int a;
	static int b=12;
	static {
		
		System.out.println("first static block Animal");
	}
	static {
		System.out.println("second static block Animal");
	}
	{
		
		System.out.println("first Instance block Animal "+a);
		a=25;
	}

	String name;
	String height;
	String weight;
	String color;
	{
		
		System.out.println("second static block Animal"+a);
		a=30;
	}

	public void eat() {
		System.out.println("eat from Animal");
	}

	 Animal(){
		
		System.out.println("DC of Animal "+a);
		a=10;
	}
	public void run() {
		System.out.println("run from Animal");
	}
	
	public void sleep(Animal sleep) {
		System.out.println("Animal");
	}
	public void sleep(Object sleep) {
		System.out.println("Object");
	}
}
