package DSA_programs.IntroToDP_dynamicProgramming;

public class SubSetSumEqualToK {
    //Recursion+Memoization Appraoch-1  
    //Time complexity=O(N*K)
    private static boolean subSetSumEqualToK(int N,int[] arr,int K,int i,boolean[][] dp){
        //base case
        if(K==0){
            return true;
        }
        if(K<0){
            return false;
        }
        if(dp[i][K]!=false){
            return dp[i][K];
        }
        boolean inc=false;
        boolean exc=false;
        if(i!=N){
            inc=subSetSumEqualToK(N, arr, K-arr[i],i+1,dp);
            exc=subSetSumEqualToK(N, arr, K, i+1,dp);
        }
        return  dp[i][K]= inc||exc;
    }
    //Approach-2 
    //Time complexity=O(N*K)
    private  static boolean solveTab(int  N,int[] arr,int K){
        boolean[][] dp=new boolean[N+1][K+1];
        //fill the 0th column of each row with true;
        for(int i=0;i<=N;i++){
            dp[i][0]=true;
        }
        boolean pick=false;
        boolean notPick=false;
        for(int i=1;i<=N;i++){
            for(int j=1;j<=K;j++){
                 notPick=dp[i-1][j];
                if(j>=arr[i-1]){
                    pick=dp[i-1][j-arr[i-1]];
                }
                dp[i][j]=pick||notPick;
            }
        }
        return dp[N][K];
    }
    public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
        boolean[][] dp=new boolean[N+1][K+1];
        //return subSetSumEqualToK(N, arr, K, 0,dp);
        return solveTab(N, arr, K);
    }
    public static void main(String[] args) {
        int[] arr={10,1,2,7,6,1,5};
        System.out.println(checkSubsequenceSum(arr.length, arr, 30));
        System.out.println(checkSubsequenceSum(arr.length, arr, 100));
    }
}
