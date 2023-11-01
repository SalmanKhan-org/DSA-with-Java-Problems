package DSA_programs.IntroToDP_dynamicProgramming;

import java.util.Arrays;

public class UniqueBSTs1 {
    //Time complexity=O(N^2)
    //Space complexity=o(N)
    public int uniqueBst(int n,int dp[]){
        //base case
        if(n<=1){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=uniqueBst(i,dp)*uniqueBst(n-i-1,dp);
        }
        return dp[n]=ans;
    }
    public int numTrees(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return uniqueBst(n,dp);
    }
    public static void main(String[] args) {
        int n=3;
        System.out.println(new  UniqueBSTs1().numTrees(n));
    }
}
