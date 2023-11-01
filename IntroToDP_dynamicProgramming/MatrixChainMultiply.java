package DSA_programs.IntroToDP_dynamicProgramming;

import java.util.Arrays;

//Approach-1 recursion+Memoization
public class MatrixChainMultiply {
    //Time complexity=O(N^3)
    //Space  complexity=O(N^2)
    static int f(int i,int j,int[] arr,int[][] dp){
        //base case
        if(i==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int mini=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int ans=arr[i-1]*arr[k]*arr[j]+f(i,k,arr,dp)+f(k+1,j,arr,dp);
            mini=Math.min(mini,ans);
        }
        return dp[i][j]=mini;
    }
    static int matrixMultiplication(int N, int arr[])
    {
        int[][] dp=new  int[N][N];
        for(int[] ar:dp){
            Arrays.fill(ar,-1);
        }
       return f(1,N-1,arr,dp);
    }
    public static void main(String[] args){
        int[] arr={10,20,30,40,50};
        System.out.println(matrixMultiplication(arr.length, arr));
    }
}
