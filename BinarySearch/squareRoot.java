package com.BinarySearch.org;

import java.util.Scanner;
//Time complexity = O(logn)
//Space complexity = O(1)
public class squareRoot {
	public static boolean findSquareRoot(int num) {
		int low=0,high = num,mid=0,result = 0,val=0;
		while(low <= high) {
			mid = low +(high-low)/2;
			val = mid*mid;
			if(val == num) {
				return true;
			}else if(val > num) {
				high = mid-1;
			}else {
				low = mid+1;
			}
		}
		return false;
	}
	
	
	
//	public static int findSquareRoot(int num) {
//		int low=0,high = num,mid=0,result = 0;
//		while(low <= high) {
//			mid = low+(high-low)/2;
//			long val = mid*mid;
//			if(val == num) {
//				return mid;
//			}else if(val > num) {
//				high = mid -1;
//			}else if(val < num){
//			 result = mid;
//			 low = mid +1;
//			}
//		}
//		return result;
//	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of which you want to find Square root:");
		int num = sc.nextInt();
		boolean result = findSquareRoot(num);
		if(result == true) {
			System.out.println("The "+num+" is a perfect square:");
		}else {
			System.out.println("The  "+num+" is not a perfect square:");
		}
	}

}
