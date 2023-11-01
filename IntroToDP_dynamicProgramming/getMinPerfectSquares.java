package DSA_programs.IntroToDP_dynamicProgramming;

import java.util.Arrays;

public class getMinPerfectSquares {
    //Approach-1 recursive solution
    //time complexity=O(N^sqrt(N))
    //space complexity=O(N)
    public int getMinSquares(int n){
        //base case
        if(n==0){
            return 0;
        }
        int ans=n;
        for(int i=1;i*i<=n;i++){
            int  temp=i*i;
            ans=Math.min(ans,getMinSquares(n-temp)+1);
        }
        return ans;
    }
    //Approach-2 using recursion + memoization
    //time  complexity=O(N*sqrt(N))
    //space complexity=O(N)+O(N);
    public int getMinSquaresMemo(int n,int[] dp){
        //base case
        if(n==0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int ans=n;
        for(int i=1;i*i<=n;i++){
            int  temp=i*i;
            ans=Math.min(ans,getMinSquaresMemo(n-temp,dp)+1);
        }
        dp[n]=ans;
        return dp[n];
    }
    //Approach-3 using Tabulation
    //time complexity=O(N*sqrt(N))
    public int getMinSquaresTab(int n){
        int[] dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        //Analyze  base case
        dp[0]=0;
        //for  remaining recursive  calls
        for(int i=1;i<=n;i++){  //O(N)
            //int ans=n;
            for(int j=1;j*j<=n;j++){//O(sqrt(N))
                 int  temp=j*j;
                 if(i-temp>=0)
                   dp[i] =Math.min(dp[i],dp[i-temp]+1);
                
            }
        }
        return dp[n];
    }
    public int MinSquares(int n)
    {
       //return getMinSquares(n);
       int[] dp=new int[n+1];
       Arrays.fill(dp,-1);
       //return getMinSquaresMemo(n,dp);
       
       return getMinSquaresTab(n);
    }
    public static void main(String[] args) {
        int N=5;
        System.out.println(new getMinPerfectSquares().MinSquares(N));
    }
}
