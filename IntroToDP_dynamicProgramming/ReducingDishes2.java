package DSA_programs.IntroToDP_dynamicProgramming;

import java.util.Arrays;

public class ReducingDishes2 {
    //Approach-2 Tabulation method
    //Timecomplexity=O(N*M);
    //Space complexity=O(N)
    private static int maxSatisfaction(int[] satisfaction) {
        int n=satisfaction.length;
        Arrays.sort(satisfaction);
        int[][] dp=new int[n+1][n+1];
        // for(int[] ar:dp){
        //     Arrays.fill(ar,-1);
        // }
        // return maxSum(satisfaction,0,1,dp);

        for(int index=n-1;index>=0;index--){
            for(int time=index;time>=0;time--){
                int include=(time+1)*satisfaction[index]+dp[index+1][time+1];
                int discard=0+dp[index+1][time];
                dp[index][time]=Math.max(include,discard);
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        int[] satisfaction={2,3,4};
        System.out.println(maxSatisfaction(satisfaction));
    }
}
