package com.Sorting.org;

import java.util.Arrays;

public class BubbleSort {
	public static void bubbleSort(int[] arr) {
		int n = arr.length;
		for(int i=0;i<n;i++) {
			boolean flag = false;
			for(int j=0;j<n-i-1;j++) {
				if(arr[j] > arr[j+1]) {
					flag  = true;
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			if(flag == false) {
				break;
			}
		}
	}
	public static void main(String[] args) {
		int arr[] = {29,14,10,37,14,7};
		bubbleSort(arr);
		System.out.println("The Array after bubble sort is: "+Arrays.toString(arr));

	}

}
