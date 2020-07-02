package com.jp.java8.lamda;

import java.util.Comparator;

public class Test {
	
	public static String reverseString(String value){
		String result="";
		if(value==null || value.length()<=1 )
		 return value;
		 else{
		       result+=value.charAt(value.length()-1);
			   result+=reverseString(value.substring(0,value.length()-1));   
		 
		 }
		 return result;
		
		}
	

	public static void main(String[] args) {
		
		System.out.println(reverseString("Jaipal"));

		Comparator<String> anonymus = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		};
		System.out.println(anonymus.compare("aaab", "aaa"));

		Comparator<String> lamda = (s1, s2) -> {
			return s1.compareTo(s2);
		};

		System.out.println(lamda.compare("aa", "ab"));
		
		
		
		Lamda lam=()->{
			return 1;
		};
		System.out.println(lam.comap());
		
		Lamda2 lam2=(value)->{
			return 1;
		};
		System.out.println(lam2.comap(1));
		
		Lamda3 lam3=(one,two)->{
			return 1;
		};
		System.out.println(lam3.comap("",""));
		
		Lamda4 lam4=(one,two)->{	
		};
		lam4.comap("","");
		
		Lamda5 lam5=(one,two)->{
			return true;
		};
		System.out.println(lam5.comap("",""));
	}
}

@FunctionalInterface
interface Lamda{
	int comap();
}

@FunctionalInterface
interface Lamda2{
	int comap(int one);
	//int comap2(); // we cant add more than one instance method inside functional interface
	default void method1() {
		System.out.println("Lamda2 method1");
	}
	static void method2(String name) {
		System.out.println(name);
	}
}

@FunctionalInterface
interface Lamda3{
	int comap(String one,String two);
}

@FunctionalInterface
interface Lamda4{
	void comap(String one,String two);
}

@FunctionalInterface
interface Lamda5{
	boolean comap(String one,String two);
}
