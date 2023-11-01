package DSA_programs.IntroToDP_dynamicProgramming;
import java.util.*;
public class minCostClimbingStairs {
    //using memoization method
     //time com=O(n)
    //space com=O(n+n)
    static  int minCost(int  n,int[] cost,int[] dp){
        if(dp[n]!=-1){
            return dp[n];
        }
        //base case
        if(n<=1){
            return dp[n]=0;
        }
        if(n==2){
            return dp[n]=Math.min(cost[0],cost[1]);
        }
        return dp[n]=Math.min(minCost(n-1,cost,dp)+cost[n-1],minCost(n-2,cost,dp)+cost[n-2]);
    }
    static int minCostClimbingStairs1(int[] cost , int N) {
        int[] dp=new int[10000];
        Arrays.fill(dp,-1);
        return minCost(N,cost,dp);
        
    }
    //by using tabulation method
     //time com=O(n)
    //space com=O(n)
    static  int minCost2(int  n,int[] cost,int[] dp){
        dp[0]=cost[0];
        dp[1]=cost[1];
        for(int i=2;i<n;i++){
            dp[i]=Math.min(dp[i-1],dp[i-2])+cost[i];
        }
        return Math.min(dp[n-1],dp[n-2]);
    }
    static int minCostClimbingStairs3(int[] cost , int N) {
        int[] dp=new int[10000];
        Arrays.fill(dp,-1);
        return minCost1(N,cost,dp);
        
    }
    //solution by space optimization
    //time com=O(n)
    //space com=O(1)
    static  int minCost1(int  n,int[] cost,int[] dp){
        int prev1=cost[0];
        int prev2=cost[1];
        for(int i=2;i<n;i++){
            int curr=Math.min(prev1,prev2)+cost[i];
            prev1=prev2;
            prev2=curr;
        }
        return Math.min(prev1,prev2);
    }
    static int minCostClimbingStairs(int[] cost , int N) {
        int[] dp=new int[10000];
        Arrays.fill(dp,-1);
        return minCost1(N,cost,dp);
        
    }
    public static void main(String[] args) {
        int[] costs={1,100,1,2,3,7};
        minCostClimbingStairs(costs, costs.length);
    }
}
