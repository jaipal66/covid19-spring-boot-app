package com.jp.hackerearth;

import java.util.Scanner;

public class FrogMovement {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        String input=scanner.nextLine();
        String[] values=input.split(" ");	
        int X = Integer.parseInt(values[0]); 
        int Y = Integer.parseInt(values[1]); 
        int s = Integer.parseInt(values[2]); 
        int T = Integer.parseInt(values[3]);
		System.out.println(solve(X, Y, s, T));
		scanner.close();
	}

	static int solve(int X, int Y, int s, int T) {
		int counter = 0;
		for (int positionX = X; positionX <= X + s; positionX++) {
			for (int positionY = Y; positionY <= Y + s; positionY++) {
				if (positionY + positionX <= T) {
					counter++;
				}
			}
		}
		return counter;
	}
}
