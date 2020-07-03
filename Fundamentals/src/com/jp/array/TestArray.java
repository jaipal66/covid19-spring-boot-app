package com.jp.array;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestArray {
	public static void testImmutability() {
		try {
			Address address = new Address();
			address.setId(1);
			address.setCity("Blore");
			address.setStreat("Vagdevi");
			address.setZipCode(560037);
			System.out.println("Address:  " + address.hashCode());
			System.out.println(address);

			Student st = new Student(1, "jaipal", address);

			System.out.println("Student: " + st.hashCode());
			System.out.println(st);
			System.out.println("===========");

			Address add = st.getAddress();
			System.out.println(add.hashCode());
			System.out.println(add);
			add.setCity("Bengaluru");
			System.out.println(st);
			System.out.println(add.getCity());
			System.out.println("Student: " + st.hashCode());
			System.out.println("Address:  " + add.hashCode());
			System.out.println(add);
		} catch (CloneNotSupportedException e) {

		}
	}

	public static void main(String[] args) throws IOException {

		

		int[] arr = getRandomArray(10);
		System.out.println(Arrays.toString(arr));
		printPair(arr, 30);

		findLargestAndSmallest(arr);

		String input = "jaipal1@23";
		for (int i = 0; i < input.length(); i++) {
			char value = input.charAt(i);
			if (Character.isDigit(value)) {

			}
		}

		int[] array = { 1, 2, 3 };
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {

		}
		testImmutability();

		moveZeroToFront();

		kadanesAlgo(arr);
		System.out.println(permutationFinder("123"));
		
		calculateAge();
	}

	public static Set<String> permutationFinder(String str) {
		Set<String> perm = new HashSet<String>();
		// Handling error scenarios
		if (str == null) {
			return null;
		} else if (str.length() == 0) {
			perm.add("");
			return perm;
		}
		char initial = str.charAt(0); // first character
		String rem = str.substring(1); // Full string without first character
		Set<String> words = permutationFinder(rem);
		for (String strNew : words) {
			for (int i = 0; i <= strNew.length(); i++) {
				perm.add(charInsert(strNew, initial, i));
			}
		}
		return perm;
	}

	public static String charInsert(String str, char c, int j) {
		String begin = str.substring(0, j);
		String end = str.substring(j);
		return begin + c + end;
	}

	public static void printPair(int[] arr, int sum) {
		Set set = new HashSet();
		for (int number : arr) {
			int second = sum - number;
			if (!set.contains(second)) {
				set.add(second);
			} else {
				System.out.println("pair is (" + number + "," + second + ")");
			}
		}
	}

	public static int[] getRandomArray(int length) {
		int[] randoms = new int[length];
		for (int i = 0; i < length; i++) {
			randoms[i] = (int) (Math.random() * 10);
		}
		return randoms;
	}

	public static void moveZeroToFront() {
		int array[] = { 1, 0, 12, 5, 6, 0, 8, 0, 9 };
		System.out.println(Arrays.toString(array));
		int start = array.length - 1;
		for (int i = array.length - 1; i >= 0; i--) {
			if (array[i] != 0) {
				array[start] = array[i];
				start--;
			}
		}
		while (start >= 0) {
			array[start] = 0;
			start--;
		}
		System.out.println(Arrays.toString(array));
	}

	public static void readFile() {

		File file = new File("Employee.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = null;

			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void kadanesAlgo(int[] array) {

		int maxSoFar = 0;
		int maxEndingHere = 0;
		int start = 0;
		int end = 0;
		int s = 0;
		for (int i = 0; i < array.length; i++) {
			maxEndingHere += array[i];
			if (maxEndingHere < 0) {
				maxEndingHere = 0;
				s = s + i;
			} else if (maxSoFar < maxEndingHere) {
				maxSoFar = maxEndingHere;
				start = s;
				end = i;
			}
		}
		System.out.println(start + " " + end);
		System.out.println(maxSoFar);
	}

	public static List<String> permute(String string) {
		return permute(string, 0, string.length() - 1);
	}

	public static void findPairs(int[] array, int key) {
		System.out.println("Array is : " + Arrays.toString(array));
		Arrays.sort(array);
		int start = 0;
		int end = array.length - 1;
		while (start < end) {
			int sum = array[start] + array[end];
			if (sum == key) {
				System.out.println("(" + array[start] + "," + array[end] + ")");
				start++;
				end--;
			} else if (sum < key) {
				start++;
			} else if (sum > key) {
				end--;
			}
		}
	}

	public static void findSecondLargest(int array[]) {
		System.out.println("Array is : " + Arrays.toString(array));
		int largest = array[0];
		int secondLargest = array[0];
		for (int number : array) {
			if (number > largest) {
				secondLargest = largest;
				largest = number;
			}

		}
		System.out.println("SecondLargest: " + secondLargest + " Largest : " + largest);
	}

	public static void findLargestAndSmallest(int array[]) {
		System.out.println("Array is : " + Arrays.toString(array));
		int largest = array[0];
		int smallest = array[0];
		for (int number : array) {
			if (number > largest) {
				largest = number;
			}
			if (number < smallest) {
				smallest = number;
			}
		}
		System.out.println("Smallest: " + smallest + " Largest : " + largest);
	}

	public static void calculateAge() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String date = sdf.format(new Date());
		int currentDate = Integer.parseInt(date.substring(8, 10));
		int currentMonth = Integer.parseInt(date.substring(5, 7));
		int currentYear = Integer.parseInt(date.substring(0, 4));
		int birthDate = 05;
		int birthMonth = 11;
		int birthYear = 1990;
		int months[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		if (birthDate > currentDate) {
			currentMonth--;
			currentDate = currentDate + months[birthMonth - 1];
		}
		if (birthMonth > currentMonth) {
			currentYear--;
			currentMonth = currentMonth + 12;
		}
		int calculatedYear = currentYear - birthYear;
		int calculatedMoth = currentMonth - birthMonth;
		int calculatedDate = currentDate - birthDate;
		System.out.println("Your are " + calculatedYear + " Yesrs : " + calculatedMoth + " Months : " + calculatedDate
				+ " Days old.");
	}

	public static List<String> permute(String string, int start, int end) {

		List<String> lists = new ArrayList();
		if (start == end) {
			lists.add(string);
		} else {
			for (int i = 1; i <= end; i++) {
				string = swap(string, start, i);
				permute(string, start + 1, end);
				string = swap(string, start, i);
			}
		}

		return lists;
	}

	public static String swap(String string, int start, int end) {
		char[] charArray = string.toCharArray();
		char temp = charArray[start];
		charArray[start] = charArray[end];
		charArray[end] = temp;
		return new String(charArray);
	}

	public static int[][] rotateMatrix(int[][] matrix, int number) {
		int temp[][] = new int[matrix[0].length][matrix.length];
		for (int i = 0; i < matrix[0].length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (number == 1)
					temp[i][j] = matrix[matrix.length - j - 1][i];
				else if (number == 0) {
					temp[i][j] = matrix[j][matrix[0].length - i - 1];
				}
			}
		}
		return temp;

	}

	public static String rightRotate(String string, int position) {
		return leftRotate(string, string.length() - position);
	}

	public static String leftRotate(String string, int position) {
		return string.substring(position) + string.substring(0, position);
	}

	public static void rotateByPosition(int[] array, int position) {
		int mod = position % array.length;
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[(i + mod) % array.length] + " ");
		}
	}

	public static void rotateMatrixInplace(int matrix[][]) {
		int length = matrix.length - 1;
		for (int i = 0; i <= length / 2; i++) {
			for (int j = i; j < length - i; j++) {
				int cellOne = matrix[i][j];
				int cellTwo = matrix[j][length - i];
				int cellThree = matrix[length - i][length - j];
				int cellFour = matrix[length - j][i];

				matrix[j][length - i] = cellOne;
				matrix[length - i][length - j] = cellTwo;
				matrix[length - j][i] = cellThree;
				matrix[i][j] = cellFour;
			}
		}
	}

	public static void printMatrix(int matrix[][]) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}

final class Student {
	private int id;
	private String name;
	private Address address;

	Student(int id, String name, Address address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Address getAddress() throws CloneNotSupportedException {
		return (Address) address.clone();
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

}

class Address implements Cloneable {
	int id;
	String city;
	String streat;
	int zipCode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreat() {
		return streat;
	}

	public void setStreat(String streat) {
		this.streat = streat;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", streat=" + streat + ", zipCode=" + zipCode + "]";
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
