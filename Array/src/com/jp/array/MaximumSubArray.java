package com.jp.array;


/**
 * @author Jaipal
 * 
 * for given input array find the sub array whose sum is maximum
 * input  : int array[]= {2,3,-4,-1,5,6,8,-2};
 * output : index is 3 to 6 and sum is : 19
 *
 */
public class MaximumSubArray {

	public static void main(String[] args) {

		int array[]= {2,3,-4,-1,5,6,8,-2};
		System.out.println(subArray(array));
	}

	private static int subArray(int array[]) {
		int maxSoFar = 0;
		int maxSum = 0;
		int start=0;
		int end=0;
		int s=0;
		for (int i = 0; i < array.length; i++) {
			maxSoFar += array[i];
			if (maxSoFar <= 0) {
				maxSoFar = 0;
				s=s+i;
			} else if (maxSum < maxSoFar) {
				maxSum = maxSoFar;
				start=s;
				end=i;
			}
		}
		System.out.println("Index is "+start+" and "+end);
		return maxSum;
	}
}
