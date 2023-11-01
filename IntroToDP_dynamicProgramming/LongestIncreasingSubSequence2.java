package DSA_programs.IntroToDP_dynamicProgramming;

public class LongestIncreasingSubSequence2 {
    static int solveTab(int n,int[] a){
        int[][] dp =new int[n+1][n+1];
        
        for(int curr=n-1;curr>=0;curr--){
            for(int prev=curr-1;prev>=-1;prev--){
                int include=0;
                if(prev==-1||a[curr]>a[prev]){
                    include=1+dp[curr+1][curr+1];
                }
                int exclude=dp[curr+1][prev+1];
        
                dp[curr][prev+1]=Math.max(include,exclude);
            }
        }
        return dp[0][0];
    }
    static int longestSubsequence(int size, int a[])
    {
        return solveTab(size,a);
    }
    public static void main(String[] args) {
        int[] a={2,3,5,6,8,4,3,2};
        System.out.println(longestSubsequence(a.length, a));
    }
}
