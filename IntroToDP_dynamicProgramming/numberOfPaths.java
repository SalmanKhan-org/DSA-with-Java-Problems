package DSA_programs.IntroToDP_dynamicProgramming;

import java.util.Arrays;

public class numberOfPaths {
    //using recursion 
    //Time complexity=O(2^m*n)
    //Space complexity=O(m*n)
    private static int totalWays(int i,int j,int m, int n){
        //base case
        if(i==m-1&&j==n-1){
            return 1;
        }
        if(i>=m||j>=n){
            return 0;
        }
        return  totalWays(i, j+1, m, n)+totalWays(i+1, j, m, n);
    }
    //Using  recursion+memoIzation
    //Time complexity=O(m*n)
    //Space complexity=O(m*n)
    long totalWaysMemo(int i,int j,int m,int n,long dp[][]){
        if(i==m-1&&j==n-1){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(i>=m||j>=n){
            return 0;
        }
        dp[i][j]= totalWaysMemo(i, j+1, m, n,dp)+totalWaysMemo(i+1, j, m, n,dp);
        return dp[i][j];
    }
    //using Tabulization
    //Time complexity=O(m*n)
    //Space complexity=O(m*n)
    long solveTab(int m,int n){
        long[][] dp=new long[m][n];

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                 if(i==m-1||j==n-1){
                     dp[i][j]=1;
                 }else{
                     dp[i][j]=(dp[i][j+1]+dp[i+1][j]);
                 }
            }
        }
        return dp[0][0];
    }
    long numberOfPaths(int m, int n)
    {
        long[][] dp=new long[m+1][n+1];
        for(long[] ar:dp){
            Arrays.fill(ar,-1);
        }
        //return  totalWaysMemo(0,0,m,n,dp);
        return solveTab(m, n);

    }
    public static void main(String[] args) {
        int  m=4,n=4;
        System.out.println(totalWays(0, 0, m, n));
    }
}
