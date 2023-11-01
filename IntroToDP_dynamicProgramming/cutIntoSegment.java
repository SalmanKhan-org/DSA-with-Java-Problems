package DSA_programs.IntroToDP_dynamicProgramming;

import java.util.Arrays;

public class cutIntoSegment {
    //simple recursion 
    //Time complexity=O(3^N)
    //space complexity=O(N)
    public static int cutSegment(int n,int x,int y,int z){
        //base case
        if(n==0){
            return 0;
        }
        //if it is not possible make segments
        if(n<0){
            return Integer.MIN_VALUE;
        }
        //cut segment using x
        int a=cutSegment(n-x,x,y,z)+1;
        //cutsegment for y
        int b=cutSegment(n-y,x,y,z)+1;
        //cut Segment for z
        int c=cutSegment(n-z,x,y,z)+1;
        
        return Math.max(a,Math.max(b,c));
    }
    public static int maximizeCuts(int n, int x, int y, int z)
    {
       int ans=cutSegment(n,x,y,z);
       if(ans<0){
           return 0;
       }
       
       return ans;
    }
    //Approach-2 Using rcursion  and memoization
    //Time complexity=O(N)
    //Space complexity=O(N)+O(N) for dp  Array and recursive calls
    public static  int cutSegmentMemo(int n,int x,int y,int z,int[] dp){
        //base case
        if(n==0){
            return 0;
        }
        //if it is not possible make segments
        if(n<0){
            return Integer.MIN_VALUE;
        }
        //if our next answer is already calculated then return it
        if(dp[n]!=-1){
            return dp[n];
        }
        //cut segment using x
        int a=cutSegmentMemo(n-x,x,y,z,dp)+1;
        //cutsegment for y
        int b=cutSegmentMemo(n-y,x,y,z,dp)+1;
        //cut Segment for z
        int c=cutSegmentMemo(n-z,x,y,z,dp)+1;
        
        dp[n]= Math.max(a,Math.max(b,c));
        
        return dp[n];
    }
    public static int maximizeCutsMemo(int n, int x, int y, int z)
    {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
       int ans=cutSegmentMemo(n,x,y,z,dp);
       if(ans<0){
           return 0;
       }
       
       return ans;
    }
    //Approach-3  Using tabulation method
    //time  complexity=O(N)
    //space complexity=O(N) for dp Array only
    public static int maximizeCutsTab(int n, int x, int y, int z)
    {
        int[] dp=new int[n+1];

       Arrays.fill(dp,Integer.MIN_VALUE);
       //base case
       dp[0]=0;
       
       for(int i=1;i<=n;i++){
           //x can be a invalid index
           if(i-x>=0){
               dp[i]=Math.max(dp[i],dp[i-x]+1);
           }
           if(i-y>=0){
               dp[i]=Math.max(dp[i],dp[i-y]+1);
           }
           if(i-z>=0){
               dp[i]=Math.max(dp[i],dp[i-z]+1);
           }
       }
       if(dp[n]<0){
           return 0;
       }
        return  dp[n];
    }
    public static void main(String[] args) {
        int N=5;
        int x=5,y=3,z=2;
        System.out.println(maximizeCuts(N, x, y, z));
    }
}
