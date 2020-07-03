package com.jp.java;

import java.util.Arrays;
import java.util.Comparator;

public class Test{

    public static void main( String args[])
    {
        String[] cities = {"Bangalore","Pune","San Francisco","New York City"};
        MySort ms = new MySort();
        Arrays.sort(cities, ms);
        System.out.println(Arrays.toString(cities));
        System.out.println(Arrays.binarySearch(cities, "New York City"));
        
    }
    static class MySort implements Comparator<String>
    {
        public int compare( String a, String b)
        {
            return b.compareTo(a);
        }
    }

public static int maxHeight(int[] stickPositions, int[] stickHeights) {
    int n = stickPositions.length;
    int m = stickHeights.length;
    int max = 0;

    for (int i=0; i<n-1; i++) {
        if (stickPositions[i]<stickPositions[i+1]-1) {
            // We have a gap
            int heightDiff =  Math.abs(stickHeights[i+1] - stickHeights[i]);
            int gapLen = stickPositions[i+1] - stickPositions[i] - 1;
            int localMax = 0;
            if (gapLen > heightDiff) {
                int low = Math.max(stickHeights[i+1], stickHeights[i]) + 1;
                int remainingGap = gapLen - heightDiff - 1;
                localMax = low + remainingGap/2;

            } else {
                localMax = Math.min(stickHeights[i+1], stickHeights[i]) + gapLen;
            }

            max = Math.max(max, localMax);
        }
    }

    return max;
}
}