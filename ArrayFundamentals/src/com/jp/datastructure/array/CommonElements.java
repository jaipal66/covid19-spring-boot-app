package com.jp.datastructure.array;

public class CommonElements {

	public static void main(String[] args) {

		int arrayOne[] = { 1, 5, 10, 20, 40, 80 };
		int arrayTwo[] = { 6, 7, 20, 80, 120 };
		int arrayThree[] = { 3, 4, 15, 20, 30, 70, 80, 120 };

		int x = 0;
		int y = 0;
		int z = 0;
		while (x < arrayOne.length && y < arrayTwo.length && z < arrayThree.length) {

			if (arrayOne[x] == arrayTwo[y] && arrayTwo[y] == arrayThree[z]) {
				System.out.println(arrayOne[x]);
				x++;
				y++;
				z++;
			} else if (arrayOne[x] > arrayTwo[y])
				y++;
			else if (arrayTwo[y] > arrayThree[z])
				z++;
			else
				x++;
		}

	}
}
