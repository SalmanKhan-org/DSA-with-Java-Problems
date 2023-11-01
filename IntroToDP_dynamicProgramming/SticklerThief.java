package DSA_programs.IntroToDP_dynamicProgramming;

import java.util.Arrays;

public class SticklerThief {
    public static int maxSum(int[] arr,int n,int i){
        //base case
        if(i>=n){
            return 0;
        }
        //if array  has  only single element
        if(n==0){
            return arr[0];
        }
        return Math.max(maxSum(arr,n,i+2)+arr[i],maxSum(arr,n,i+1)+0);
        
    }
    public static  int FindMaxSum(int arr[], int n)
    {
        return  maxSum(arr,n,0);
        
    }
    //using recursion + memoization
    public static int maxSum1(int[] arr,int n,int i,int[] dp){
        //base case
        if(i>=n){
            return 0;
        }
        //if array  has  only single element
        if(n==0){
            return arr[0];
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int res= Math.max(maxSum1(arr,n,i+2,dp)+arr[i],maxSum1(arr,n,i+1,dp)+0);
        dp[i]=res;
        
        return dp[i];
        
    }
    public static int FindMaxSum1(int arr[], int n)
    {
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return  maxSum1(arr,n,0,dp);
        
    }
    //using tabulation method
    public int FindMaxSum2(int arr[], int n)
    {
        int[] dp=new int[n];
        dp[0]=arr[0];
        dp[1]=Math.max(arr[1],arr[0]);
        for(int i=2;i<n;i++){
            int incl=dp[i-2]+arr[i];
            int excl=dp[i-1];
           
            dp[i]=Math.max(incl,excl);
        }
        return dp[n-1];
        
    }
    public static void  main(String[] args){
        int[] arr={3,4,7,4,2};
        System.out.println(FindMaxSum(arr, arr.length));
        System.out.println(FindMaxSum1(arr, arr.length));
    }
}
