package DSA_programs.IntroToDP_dynamicProgramming;

import java.util.Arrays;

public class countDerangement {
    static int MOD=1000000007;
	public static long countDerangements(int n) {
		//base case
		if(n==1){
			return 0;
		}
		if(n==2){
			return 1;
		}

		return ( ((n-1)%MOD)* ((
			               (countDerangements(n-2))%MOD)+
		                  ((countDerangements(n-1))%MOD))
						  )%MOD;
	}
    //using memoization
    public static long countMemo(int n,long[] dp){
		//base case
		if(n==1){
			return 0;
		}
		if(n==2){
			return 1;
		}
		if(dp[n]!=-1){
			return dp[n];
		}
		dp[n]= ( ((n-1)%MOD)* ((
			               (countMemo(n-2,dp))%MOD)+
		                  ((countMemo(n-1,dp))%MOD))
						  )%MOD;
	    return dp[n];
	}
    public static long countDerangementsMemo(int n) {
		long[] dp=new  long[n+1];
		Arrays.fill(dp, -1);
		return countMemo(n,dp);
    }
    //Using tabulation
    public static long countTab(int n,long[] dp){
		dp[1]=0;
		dp[2]=1;

		for(int i=3;i<=n;i++){
			long second=dp[i-1]%MOD;
			long first=dp[i-2]%MOD;
			long  sum=(first+second)%MOD;
			long res=((i-1)*sum)%MOD;
			dp[i]=res;
		}
		return dp[n];
	}
	public static long countDerangementsTab(int n) {
		long[] dp=new  long[n+1];
		
		return countTab(n,dp);
    } 
    public static void main(String[] args) {
        System.out.println(countDerangements(4));
    }
}
