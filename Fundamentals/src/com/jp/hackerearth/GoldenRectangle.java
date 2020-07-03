package com.jp.hackerearth;

import java.util.Scanner;

public class GoldenRectangle {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		long rectangles = scan.nextLong();
		double width, height = 0;
		long cGolRec = 0;
		double ratio = 0;
		while (rectangles > 0) {
			width = scan.nextLong();
			height = scan.nextLong();
			if (width != 0 && height != 0) {
				if (width >= height) {
					ratio = width / height;
					// ratio = Math.round(ratio*100.0)/100.0;
				} else {
					ratio = height / width;
					// ratio = Math.round(ratio*100.0)/100.0;
				}
				// System.out.println("RATIO: "+ratio);
				if (ratio >= 1.6 && ratio <= 1.7) {
					// System.out.println("I was looking for this result only--> "+ratio);
					cGolRec++;
					// ratios.add(ratio);
				}
			}
			rectangles--;
		}
		System.out.println(cGolRec);
		scan.close();
	}
}
