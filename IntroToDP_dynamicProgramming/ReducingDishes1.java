package DSA_programs.IntroToDP_dynamicProgramming;

import java.util.Arrays;

public class ReducingDishes1 {
    //Approach-1 Recursion+memoization
    //Time complexity=O(2^N)
    //Space complexity=O(N*M)where M is the length of the satisfaction Array
    public static int maxSum(int[] satisfaction,int index,int time,int[][] dp){
        //base case
        if(index>=satisfaction.length){
            return 0;
        }
        if(dp[index][time]!=-1){
            return dp[index][time];
        }
        //call  for include dishes
        int include=time*satisfaction[index]+maxSum(satisfaction,index+1,time+1,dp);
        //call for discard dishes
        int discard=0+maxSum(satisfaction,index+1,time,dp);
        //return max of include and discard
        return dp[index][time]=Math.max(include,discard);
    }
    public static int maxSatisfaction(int[] satisfaction) {
        int n=satisfaction.length;
        Arrays.sort(satisfaction);
        int[][] dp=new int[n+1][n+1];
        for(int[] ar:dp){
            Arrays.fill(ar,-1);
        }
        return maxSum(satisfaction,0,1,dp);
    }
    public static void main(String[] args) {
        int[] satisfaction={2,3,4};
        System.out.println(maxSatisfaction(satisfaction));
    }
}
