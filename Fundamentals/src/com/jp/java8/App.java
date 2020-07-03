package com.jp.java8;

public class App {

	public static void main(String[] args) {


		labaled:
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				System.out.print("A");
				if(i==5)
					break labaled;
			}
			System.out.println();
		}
	}
}
