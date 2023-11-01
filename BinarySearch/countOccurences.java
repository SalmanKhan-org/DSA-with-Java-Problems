package com.BinarySearch.org;

import java.util.Scanner;

public class countOccurences {
	public static int firstOccurence(int arr[], int target) {
		int low=0,high=arr.length-1,mid=0,result=-1;
		while(low <= high) {
			mid = low +(high-low)/2;
			if(arr[mid] == target) {
				result = mid;
				high = mid-1;
			}else if(arr[mid] < target){
				low = mid+1;
			}else {
				high = mid-1;
			}
		}
		return result;
	}
	public static int lastOccurence(int arr[], int target) {
		int low=0,high=arr.length-1,mid=0,result1=-1;
		while(low<=high) {
			mid = low+(high-low)/2;
			if(arr[mid] == target) {
				result1 =mid;
				low = mid+1;
			}else if(arr[mid]>target){
				high = mid-1;
			}else {
				low = mid+1;
			}
		}
		return result1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the Array:"); 
		int size = sc.nextInt();
		int arr[] =new int[size];
 		System.out.println("Enter the elements of the array:");
		for(int i=0;i<size;i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("Enter the target element:");
		int ele = sc.nextInt();
		int first = firstOccurence(arr,ele);
		int last = lastOccurence(arr,ele); 
		if(first == last && first == -1) {
			System.out.println("The "+ele+" not present in the Array:");
		}else {
			System.out.println("The "+ele+" is present "+(last-first+1)+" time/times");
		}

	}
}
