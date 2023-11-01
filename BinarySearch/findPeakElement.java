package com.BinarySearch.org;

import java.util.Scanner;

public class findPeakElement {
	public static int peakElement(int[] arr ) {
		int low = 0, high = arr.length-1,mid=0;
		while(low < high) {
			mid = low+(high-low)/2;
			if(arr[mid] < arr[mid+1]) {
				low = mid+1;
			}else {
				high = mid;
			}
		}
		return low;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the array:");
		int size = sc.nextInt();
		int[] arr = new int[size];
		System.out.println("Enter the elements of the Array:");
		for(int i=0;i<size;i++) {
			arr[i] = sc.nextInt();
		}
		int index = peakElement(arr);
		System.out.println("The peak element present at the index:"+index);
	}

}
