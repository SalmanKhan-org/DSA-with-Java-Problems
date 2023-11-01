package com.Sorting.org;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
	public static void selectionSort(int arr[]) {
		int n = arr.length;
		for(int i=0;i<n;i++) {
			int min_idx = i;
			for(int j=i+1;j<n;j++) {
				if(arr[j] < arr[min_idx]) {
					min_idx = j;
				}
			}
			if(min_idx != i) {
				int temp = arr[min_idx];
				arr[min_idx] = arr[i];
				arr[i] = temp;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the Array:");
		int size = sc.nextInt();
		int arr[] = new int[size];
		System.out.println("Enter the element of the Array:");
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		selectionSort(arr);
		System.out.println("The Array after selection Sort:");
		System.out.println(Arrays.toString(arr));
	}

}
