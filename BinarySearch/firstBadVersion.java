package com.BinarySearch.org;

import java.util.Scanner;

public class firstBadVersion {
	public static boolean validSquare(int num) {
		int low = 0, high = num;
		while(low <= high) {
			int mid = low+(high-low)/2;
				int val = mid*mid;
				if(val == num) {
					return true;
				}else if(val>num) {
					high = mid-1;
				}else {
					low = mid+1;
				}
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number:");
		int num = sc.nextInt();
		boolean result = validSquare(num);
		if(result == true) {
			System.out.println("Perfect Square;");
		}

	}

}
