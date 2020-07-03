package com.jp.oops.java8;

public class Employee extends Person {

	
	static int personMethod() throws RuntimeException{
		System.out.println("EmployeeIterface personStaticMethod");
		return 1;
	}
	public static void main(String[] args) {
		
		A a =new C();
		a.one();
		a.two();
		//a.three();
		
		B b= (B)a;
		b.three();
	}

}


class A{
	
	void one(){
		System.out.println("A one");
	}
	void two(){
		System.out.println("A two");
	}
}

class B extends A{
	void one(){
		System.out.println("B one");
	}
	void three(){
		System.out.println("B three");
	}
}

class C extends B{
	void two(){
		System.out.println("C two");
	}
	void three(){
		System.out.println("C three");
	}
}
