package com.jp.java8.stream;

class A1 {
    public int i;
    protected int j;
}  


class B2 extends A1 {
    int j;

    void display() {
        super.j = 3;
        super.i = 10;
        System.out.println(i + " " + j);
    }
}

public class TestOne {

    public static void main(String args[]){

      final StringBuilder sb=new StringBuilder("Hello-");   
      sb.append("test");
      System.out.println(sb);
      
    }




	static int convertBinaryStringToDecimal(StringBuilder binaryString) {
		System.out.println(binaryString.toString());
		System.out.println(binaryString.reverse().toString());
		String s=binaryString.toString();
		int number = Integer.parseInt(s);
		int decimal = 0;
		int p = 0;
		while (true) {
			if (number == 0)
				break;
			else {
				int temp = number % 10;
				decimal += temp + Math.pow(2, p);
				number = number / 10;
				p++;
			}

		}
		return decimal;
	}

	static String convertDecimalToBinary(int number) {
		String result = "";
		int array[]=new int[100];
		int index=0;
		while (number > 0) {
			array[index++]= number % 2;
			number = number / 2;
		}
		
       for(int i=index-1;i>=0;i--) {
    	   result+=array[i];
       }
       return result;
	}
}
