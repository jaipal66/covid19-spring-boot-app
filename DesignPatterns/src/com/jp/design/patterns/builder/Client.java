package com.jp.design.patterns.builder;

public class Client {

	public static void main(String[] args) {

		
		 Game cricket = new Game.GameBuilder()
				 .homeTeam("India")
		         .awayTeam("Australlia") 
		         //.weather("cold") 
		         .stadium("Chinnaswammy") 
		         .build();
		  System.out.println(cricket);
		 

		
		
		String str = "1x0*12=1200";//3x + 12 = 46";//1x0*12=1200 //4-2=x
		str = str.replaceAll(" ", "");
		int indexOfEqual = str.indexOf("=");

		char charArray[] = str.toCharArray();
		String targetValue = str.substring(indexOfEqual + 1, str.length());
		String secondValue = "";
		String firstValue = "";
		int indexOfFirstOperator = 0;
		char firstOperator = 0;
		for (int i = 0; i < charArray.length; i++) {
			char ch = charArray[i];
			if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				firstOperator = ch;
				indexOfFirstOperator = str.indexOf(ch);
				secondValue = str.substring(indexOfFirstOperator + 1, indexOfEqual);
				firstValue = str.substring(0, indexOfFirstOperator);
			}
		}
		if (firstOperator == '+') {
			int val = Integer.parseInt(targetValue) - Integer.parseInt(secondValue);
			String valS = val + "";
			int index = firstValue.indexOf('x');
			System.out.println(valS.charAt(index));
		} else if (firstOperator == '-') {
			int val = Integer.parseInt(targetValue) + Integer.parseInt(secondValue);
			String valS = val + "";
			int index = firstValue.indexOf('x');
			System.out.println(valS.charAt(index));
		} else if (firstOperator == '*') {
			int val = Integer.parseInt(targetValue) / Integer.parseInt(secondValue);
			String valS = val + "";
			int index = firstValue.indexOf('x');
			System.out.println(valS.charAt(index));
		} else if (firstOperator == '/') {
			int val = Integer.parseInt(targetValue) * Integer.parseInt(secondValue);
			String valS = val + "";
			int index = firstValue.indexOf('x');
			System.out.println(valS.charAt(index));
		}
	}
}
