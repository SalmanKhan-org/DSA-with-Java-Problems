package com.BinarySearch.org;

import java.util.Scanner;

public class FirstOccurence {
	public static int findFirstOccurence(int[] arr, int target) {
		int result = -1, low = 0, high = arr.length-1,mid=0;
		while(low<= high) {
			mid = low+(high-low)/2;
			if(arr[mid] == target) {
				result = mid;
				high = mid-1;
			}else if(arr[mid]>target) {
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
		 int[] arr = new int[size];
		 System.out.println("Enter the element of the Array:");
		 for(int i=0;i<arr.length;i++) {
			 arr[i] = sc.nextInt();
		 }
		 System.out.println("Enter the target element:");
		 int target = sc.nextInt();
		 sc.close();
		 int result = findFirstOccurence(arr,target);
		 if(result == -1) {
			 System.out.println("The Target element is not present in the array:");
		 }else {
			 System.out.println("The First occurence of the "+target+" present at index:"+result);
		 }
	}

}
