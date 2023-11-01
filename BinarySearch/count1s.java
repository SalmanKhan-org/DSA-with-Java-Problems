package com.BinarySearch.org;

import java.util.Scanner;

public class count1s {
	public static int count1s(int arr[]) {
		int low=0,high=arr.length-1,mid=0,result=0;
		while(low <= high) {
			mid = low +(high-low)/2;
			if(arr[mid] == 1) {
				result = mid;
				high = mid -1;
			}else {
				low = mid +1;
			}
		}
		return arr.length-result;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the array:");
		int size = sc.nextInt();
		int arr[] = new int[size];
		System.out.println("Enter the element of the Array:");
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		int number1s= count1s(arr);
	    System.out.println("The number of 1's in the Array:"+number1s);
	}
}
