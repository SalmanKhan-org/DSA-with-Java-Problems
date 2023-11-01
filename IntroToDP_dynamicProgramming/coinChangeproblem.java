package DSA_programs.IntroToDP_dynamicProgramming;

public class coinChangeproblem {
    //with memoization  techniques
    //time complexity=O(2^n);
    //space complexity=O(n)
    public long countWays(long[][] dp,int[]  coins,int N,int sum){
        //base case if  your sum will be equal to 0 return 1
       if(sum==0){
           return dp[N][sum]=1;
       }
       //if  our sum will be less than 0  means no ways  possible
       if(N==0||sum<0){
           return 0;
       }
       //if subProblem is previously solved
       if(dp[N][sum]!=-1){
           return  dp[N][sum];
       }
       
       //recurrence relation
       return dp[N][sum]=countWays(dp,coins,N,sum-coins[N-1])+countWays(dp,coins,N-1,sum);
   }
   public long count(int coins[], int N, int sum) {
       long[][] dp=new long[N+1][sum+1];
       for(int  i=0;i<=N;i++){
           for(int j=0;j<=sum;j++){
               dp[i][j]=-1;
           }
       }
       return countWays(dp,coins,N,sum);
   }
   //by using  space optimization techniques
   public static long count2(int coins[], int N, int sum) {
        long[] dp=new long[sum+1];
        dp[0]=1;
       for(int  i=0;i<N;i++){
            for(int j=coins[i];j<=sum;j++){
                 dp[j]+=dp[j-coins[i]];
            }
        }
        return dp[sum];
    }
    public static void main(String[] args) {
        int[] coins={1,2};
        int sum=3;
        System.out.println(count2(coins, coins.length, sum));
    }
}
