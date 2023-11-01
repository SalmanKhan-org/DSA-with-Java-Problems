package DSA_programs.IntroToDP_dynamicProgramming;

import java.util.Arrays;

public class CombinationSumFour {
    //recursive solution
    //time  complexity=O(target^N) where N is the sizeof the Array
    public static int findAllWays(int nums[], int tar){
        //base case
        if(tar==0){
            return 1;
        }
        //if target will be neagtive
        if(tar<0){
            return 0;
        }
        int ans=0;
        //we can use  one element multiple times so we have to use afor loop
        for(int i=0;i<nums.length;i++){
            ans+=findAllWays(nums,tar-nums[i]);
        }
        return ans;
    }
    //Approach-2 Recursion + memoization
    //Time compllexity=O(target*N)
    //space complexity=O(N)+O(N)
    public static int findAllWaysMemo(int[] nums,int tar,int[] dp){
         //base case
        if(tar==0){
            return 1;
        }
        //if target will be neagtive
        if(tar<0){
            return 0;
        }
        if(dp[tar]!=-1){
            return dp[tar];
        }
        int ans=0;
        //we can use  one element multiple times so we have to use afor loop
        for(int i=0;i<nums.length;i++){
            ans+=findAllWaysMemo(nums,tar-nums[i],dp);
        }
        dp[tar]=ans;
        return dp[tar];
    }
    //Time complexity=O(target*N)

    public static int findAllWaysTab(int[] nums,int tar){
        //create a  dp Array
        int[] dp=new int[tar+1];
        //Analyze base case
        dp[0]=1;
        //for remaining recursive call
        for(int i=1;i<=tar;i++){
            for(int j=0;j<nums.length;j++){
                //index can be invalid
                if(i-nums[j]>=0)
                    dp[i]+=dp[i-nums[j]];
            }
        }
        return dp[tar];
    }
    public static int findWays(int num[], int tar) {
       //return findAllWays(num,tar);
       int[] dp=new int[tar+1];
       Arrays.fill(dp,-1);
       //return findAllWaysMemo(num,tar,dp);

       return findAllWaysTab(num,tar);
    }
    public static void main(String[] args) {
        int[] nums={1,2};
        System.out.println(findAllWays(nums, 3));
    }
}
