package DSA_programs.IntroToDP_dynamicProgramming;

import java.util.Arrays;

public class noOfWaysWithmSteps {
    //Recursive Solution
    //Time complexity=O(m^n)
    //Space complexity=O(n)
    private static int countWays(int n,int m){
        //base case
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        int ans=0;
        for(int i=1;i<=m;i++){
            ans+=countWays(n-i, m);
        }
        return ans;
    }
    //Resursion +  memoization
    //Time complexity=O(n*m)
    //Space complexity=O(n)+O(n)
    private static int countWaysMemo(int n,int m,int[] dp){
        //base case
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int ans=0;
        for(int i=1;i<=m;i++){
            ans+=countWays(n-i, m);
        }
        dp[n] =ans;
        return dp[n];
    }
    //Approach 3
    private static int countWaysTab(int n,int m){
        int[] dp=new int[n+1];
       //ways to reach at 0th stair
       dp[0]=1;
       //ways to reach at 1th stair
       dp[1]=1;
       //ways to reach at 2nd stair
       dp[2]=2;
       //for rest of the  stairs
       for(int j=3;j<=n;j++){
            dp[j]=0;
            for(int i=1;i<=m&&(j-i)>=0;i++){
                dp[j]+=dp[j-i];
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n=5;
        int m=3;
        //System.out.println(countWays(n, m));
        int[] dp=new  int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(countWaysMemo(n, m, dp));
        System.out.println(countWaysTab(n, m));
    }
}
