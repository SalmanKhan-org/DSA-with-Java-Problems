package DSA_programs.IntroTo2DArray;

import java.util.Arrays;
import java.util.Scanner;

public class Reshapematrix {
     public static int[][] reshapematrix(int[][] arr){
        int m = arr.length;
        int n = arr[0].length;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows for New Matrix:");
        int row = sc.nextInt();
        System.out.println("Enter the number of columns for new matrix:");
        int col = sc.nextInt();
        int[][] reshapematrix = new int[row][col];
        int row1=0,col1=0;
        if(m*n!=row*col){
            return arr;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                reshapematrix[row1][col1] = arr[i][j];
                col1++;
                if(col1==col){
                    row1++;
                    col1=0;
                }
            }
        }
        return reshapematrix;
    }
    public static void main(String[] args) {
        int[][] M={{1,2,3},{4,5,7}};
        int[][] RM=reshapematrix(M);
        for(int[] ar:RM){
            for(int i:ar){
                System.out.print(i+"  ");
            }
            System.out.println();
        }
    }
}
