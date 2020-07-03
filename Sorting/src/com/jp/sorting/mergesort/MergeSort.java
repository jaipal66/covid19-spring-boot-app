package com.jp.sorting.mergesort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int arr[] = { 10, 7, 8, 9, 1, 5 };
		System.out.println(Arrays.toString(arr));
		mergeSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	public static void mergeSort(int intArray[], int left, int right) {

		if (left < right) {
			int middle = (left + right) / 2;
			mergeSort(intArray, left, middle);
			mergeSort(intArray, middle + 1, right);
			merge(intArray, left, middle, right);
		}
	}

	public static void merge(int intArray[], int left, int middle, int right) {
		   int copy[]=new int[left+right];
		    int i = left, j = middle+1, k = left;
		    while (i <= middle && j <= right) {
		        if (intArray[i] <= intArray[j]) {
		            copy[k++] = intArray[i++];
		        }
		        else {
		            copy[k++] = intArray[j++];
		        }
		    }
		    while (i < left) {
		        copy[k++] = intArray[i++];
		    }
		   while(j<right) {
			   copy[k++]=intArray[j++];
		   }
		   for(int p=0;p<=k;p++) {
			   intArray[p]=copy[p];
		   }
	}
}
