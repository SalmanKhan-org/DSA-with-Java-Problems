package DSA_programs.IntroToDP_dynamicProgramming;

import java.util.Arrays;

public class PaintTheFence {
    int MOD=1000000007;
    long add(long a,long b){
        return (a%MOD+b%MOD)%MOD;
    }
    long mul(long a,long b){
        return ((a%MOD)*(b%MOD))%MOD;
    }
    long countWays(int n,int k)
    {
        //base case
        if(n==1){
            return k;
        }
        if(n==2){
            return add(k,mul(k,k-1));
        }
        
        return add(mul(countWays(n-2,k),k-1),mul(countWays(n-1,k),k-1));
    }
    //Approach-2 Using memoization method
    long paintTheFenceMemo(int n,int k,long[] dp){
        if(n==1){
           return k;
       }
       if(n==2){
           return add(k,mul(k,k-1));
       }
       //check if the answer  is already calculated or not
       if(dp[n]!=-1){
           return dp[n];
       }
       dp[n]=  add(mul(paintTheFenceMemo(n-2,k,dp),k-1),mul(paintTheFenceMemo(n-1,k,dp),k-1));
       return dp[n];
   }
   long countWaysMemo(int n,int k)
   {
      long[] dp=new long[n+1];
      Arrays.fill(dp,-1);
      return paintTheFenceMemo(n,k,dp);
   }
   //Approach-3 using tabulation method
   //time complexity=O(N)
   //Space complexity=O(N)
   long countWaysTab(int n,int k)
   {
       if(n==1) return k;
      long[] dp=new long[n+1];
      Arrays.fill(dp,0);
      //return paintTheFenceMemo(n,k,dp);
      dp[1]=k;
      dp[2]=add(k,mul(k,k-1));
      
      for(int i=3;i<=n;i++){
          dp[i]=add(mul(dp[i-2],k-1),mul(dp[i-1],k-1));
      }
      return dp[n];
   }
   //Approach-4 using space optimization technique
   long countWaysSpace(int n,int k)
   {
       if(n==1) return k;
      //return paintTheFenceMemo(n,k,dp);
      long prev1=k;
      long prev2=add(k,mul(k,k-1));
      
      for(int i=3;i<=n;i++){
          long ans=add(mul(prev1,k-1),mul(prev2,k-1));
          prev1=prev2;
          prev2=ans;
      }
      return prev2;
   }
    public static void main(String[] args){
        int n=1;
        int k=17;
        System.out.println(new  PaintTheFence().countWays(n, k));
    }
}
