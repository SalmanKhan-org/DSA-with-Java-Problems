package com.BinarySearch.org;
import java.util.*;
public class ArrangeCoins {
	public static int arrangeCoins(int num) {
//		int low = 0, high = num,mid=0;
//		while(low <= high) {
//			mid = low+(high-low)/2;
//			if(num >= (mid*(mid+1)/2)) {
//				low = mid+1;
//			}else {
//				high = mid-1;
//			}
//		}
//		return low-1;
		
		return (int)(Math.sqrt(2*(num)+0.25)-0.5);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of the coins:");
		int coins = sc.nextInt();
		int result = arrangeCoins(coins);
		System.out.println("The coins are arranged in the following stairs:"+result);

	}

}
