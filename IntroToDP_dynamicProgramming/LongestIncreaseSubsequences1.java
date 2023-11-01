package DSA_programs.IntroToDP_dynamicProgramming;
import java.util.*;
public class LongestIncreaseSubsequences1 {
    static int solve(int a[],int n,int curr,int prev,int[][] dp) {
        //base case
        if(curr>=n){
            return 0;
        }
        if(dp[curr][prev+1]!=-1){
            return dp[curr][prev+1];
        }
        //include
        int include=0;
        if(prev==-1||a[curr]>a[prev]){
            include=1+solve(a,n,curr+1,curr,dp);
        }
        int exclude=solve(a,n,curr+1,prev,dp);
        
        return dp[curr][prev+1]=Math.max(include,exclude);
    }
    static int longestSubsequence(int size, int a[])
    {
        int[][] dp=new  int[size][size+1];
        for(int[] ar:dp){
            Arrays.fill(ar,-1);
        }
        return solve(a,size,0,-1,dp);
    }
    public static void main(String[] args) {
        int[] arr={5,6,7,3,2,9,8};
        System.out.println(longestSubsequence(arr.length, arr));
    }
}
