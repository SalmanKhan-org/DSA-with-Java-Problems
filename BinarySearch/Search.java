package com.BinarySearch.org;

import java.util.Scanner;

public class Search {
	public static int search(int arr[], int target) {
		int low = 0, high=arr.length-1,mid=0;
		while(low<=high) {
			mid = low+(high-low)/2;
			if(arr[mid] == target) {
				return mid;
			}else if(arr[low] <= arr[mid]) {
				if(target>= arr[low] &&target<arr[mid]) {
					high = mid-1;
				}else {
					low = mid+1;
				}
			}else if(arr[low] > arr[mid]){
				if(target > arr[mid]&&target<=arr[high]) {
					low = mid+1;
				}else {
					high = mid-1;
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the Array:");
		int size =sc.nextInt();
		int arr[] = new int[size];
		System.out.println("Enter the elements of the Array:");
		for(int i=0;i<size;i++) {
			arr[i] = sc.nextInt();
		}
		System .out.println("Enter the searching element:");
		int ele = sc.nextInt();
		int index = search(arr,ele);
		if(index != -1) {
			System.out.println("The "+ele+" found at the index "+index);
		}else {
			System.out.println(ele+" Not present in the array:");
		}
	}

}
