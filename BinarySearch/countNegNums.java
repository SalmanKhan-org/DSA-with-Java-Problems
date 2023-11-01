package com.BinarySearch.org;
//count negative numbers in sorted 2D matrix;
public class countNegNums {
	public static void main(String[] args) {
		int[][] arr= {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};	
		int num = countNeagtiveNumber(arr);
		System.out.println("The "+num+" Neagtive numbers are present in the array:");
	}

	private static int countNeagtiveNumber(int[][] arr) {
		int m=arr.length,n=arr[0].length, row= m-1,col = 0,cnt=0;
		while(row >=0 && col <m) {
			if(arr[row][col] <0) {
				cnt += n-col;
				row--;
			}else {
				col++;
			}
		}
		return cnt;
	}
}
