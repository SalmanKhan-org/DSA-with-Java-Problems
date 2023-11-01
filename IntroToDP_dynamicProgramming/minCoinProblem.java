package DSA_programs.IntroToDP_dynamicProgramming;

import java.util.Arrays;

public class minCoinProblem {
    //with recursion
    //time complexity=(V^M);

    public static int minCoins(int coins[], int M, int V) 
	{ 
	    //base case 
	    if(V==0){
	        return 0;
	    }
	    
	    int res=Integer.MAX_VALUE;
	    
	    for(int i=0;i<M;i++){
	        if(coins[i]<=V){
	            int subres=minCoins(coins,M,V-coins[i]);
	            
	            if(subres!=Integer.MAX_VALUE&&subres+1<res){
	                res=subres+1;
	            }
	        }
	    }
	    return res;
	} 
    //with recursion  +  memoization
    //time complexity=O(M*V);
    //space complexity=O(V+M);
    public int minCoinTomakeAmmount(int[] dp,int[] coins,int  M,int V){
        if(V==0){
           return 0;
       }
       if(dp[V]!=-1){
           return dp[V];
       }
       int res=Integer.MAX_VALUE;
       
       for(int i=0;i<M;i++){
           if(coins[i]<=V){
               int subres=minCoinTomakeAmmount(dp,coins,M,V-coins[i]);
               if(subres!=Integer.MAX_VALUE&&subres+1<res){
                   res=subres+1;
               }
           }
       }
       dp[V]=res;
       return res;
   }
   public int minCoins1(int coins[], int M, int V) 
   { 
       //base case 
      int[] dp=new int[V+1];
      Arrays.fill(dp,-1);
      int res=minCoinTomakeAmmount(dp,coins,M,V);
      if(res==Integer.MAX_VALUE){
          return -1;
      }else{
          return res;
      }
   }  
     //using tabulation method
     public int minCoinTomakeAmmount1(int[] coins,int  M,int V){
        int[] dp=new int[V+1];
	   for(int i=1;i<=V;i++){
	       dp[i]=Integer.MAX_VALUE;
	   }
        //base case if sumis zero
        dp[0]=0;
        //start a for  loop which refers to sum at particular index
        for(int i=1;i<=V;i++){
            //another for loop which compute  how many coin need to make sum i
            for(int j=0;j<M;j++){
                //if our sum will be greater than coin
                if(coins[j]<=i){
                    int subres=dp[i-coins[j]];
                    if(subres!=Integer.MAX_VALUE&&subres+1<dp[i]){
                        dp[i]=subres+1;
                    }
                }
            }
        }
        if(dp[V]==Integer.MAX_VALUE) return -1;
        
        return dp[V];
    }
	public int minCoins3(int coins[], int M, int V) 
	{ 
	   int res=minCoinTomakeAmmount1(coins,M,V);
	   return  res;
	} 
    public static void main(String[] args){
        int[] coins={1,2,4};
        System.out.println(minCoins(coins, coins.length, 5));
    }
};
