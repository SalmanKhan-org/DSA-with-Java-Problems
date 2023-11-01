package DSA_programs.IntroTo2DArray;

import java.util.Scanner;

public class PrefixSum {
    public static int prefixSum(int[][] arr,int r1, int c1, int r2, int c2){
        int m=arr.length;
        int n = arr[0].length;
        //Row wise prefix sum
        for(int i=0;i<m;i++){
            for(int j=1;j<n;j++){
                arr[i][j] += arr[i][j-1];
                
            }
        }
        //Column wise prefix sum
        for(int j=0;j<n;j++){
            for(int i=1;i<m;i++){
                arr[i][j] += arr[i-1][j];
            }
        }
        //prefix sum
        int sum=0,up=0,left=0,repeated_region=0,result=0;
        //c1++;r1++;c2++;r2++;
        sum = arr[r2][c2];
        if(r1>=1){
        up = arr[r1-1][c2];
        }
        if(c1>=1){
        left = arr[r2][c1-1];
        }
        if(r1>=1 && c1>=1){
        repeated_region = arr[r1-1][c1-1];
        }
        result = sum - up - left + repeated_region;
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int row =  sc.nextInt();
        System.out.println("Enter the number of columns:");
        int columns = sc.nextInt();
        int arr[][] = new int[row][columns];
        System.out.println("Enter the elements of the first Array:");
        for(int i=0;i<row;i++){
            for(int j=0;j<columns;j++){
                System.out.print(i+"th"+j+"th:");
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println("The elements of the matrix is:");
        for(int i=0;i<row;i++){
            for(int j=0;j<columns;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("The enter starting row index:");
        int r1 = sc.nextInt();
        System.out.println("Enter the starting column index:");
        int c1 = sc.nextInt();
        System.out.println("Enter the ending row index:");
        int r2 = sc.nextInt();
        System.out.println("Enter the ending column index:");
        int c2 = sc.nextInt();
        int prefixSum = prefixSum(arr, r1, c1, r2, c2);
        System.out.println("The prefix Sum is :"+prefixSum);
    }
}
