package com.BinarySearch.org;

import java.util.Scanner;

public class lastOccurence {
	public static int lastOccurence(int arr[], int target) {
		int low=0,high=arr.length-1,mid=0,result=-1;
		while(low <= high) {
			mid = low +(high-low)/2;
			if(arr[mid] == target) {
				result = mid;
				low = mid+1;
			}else if(arr[mid] > target) {
				high = mid -1;
			}else {
				low = mid+1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the Array:");
		int size = sc.nextInt();
		int[] arr= new int[size];
		System.out.println("Enter the elements of the Array:");
		for(int i=0;i<size;i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("Enter the target element:");
		int x = sc.nextInt();
		int result = lastOccurence(arr,x);
		if(result == -1) {
			System.out.println("The element "+x+" is not present in the Array:");
		}else {
			System.out.println("The last occurence of the elements"+x+" is present at index:"+result);
		}

	}

}
