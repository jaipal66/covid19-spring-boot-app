package com.jp.oops.polymorphism;
public class App {
	{
		System.out.println(this.hashCode());
	}
	public  static void main(String[] args) {
       System.out.println(args.length);
		Person person = new Employee("jaipal");
		try {
			person.sleep(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public static void main(String args) {
		System.out.println("String");
	}
}
