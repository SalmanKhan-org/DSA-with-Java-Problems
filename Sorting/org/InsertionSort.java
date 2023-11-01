package com.Sorting.org;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
	public static void insertionSort(int[] arr) {
		int n = arr.length;
		for(int i=0;i<n;i++) {
			int j=i;
			while(j>0 && arr[j]< arr[j-1]) {
				int temp = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = temp;
				j--;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the Array:");
		int size = sc.nextInt();
		int[] arr = new int[size];
		System.out.println("Enter the element of the Array:");
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		insertionSort(arr);
		System.out.println("The after insertion Sort:");
		System.out.println(Arrays.toString(arr));
	}
}
