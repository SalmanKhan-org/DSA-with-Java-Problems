package DSA_programs.IntroToDP_dynamicProgramming;

public class PartitionEqualSubSetSum {
    //Recursion+MemoIzation
    //Timecomplexty=O(N*Sum)
    private static boolean subSetSum(int[] arr,int sum,int i,boolean[][] dp){
        if(sum==0){
            return true;
        }
        if(i>=arr.length){
            return false;
        }
        if(dp[i][sum]!=false){
            return dp[i][sum];
        }
        boolean inc=false;
        boolean exc=false;
        if(arr[i]<=sum){
            inc=subSetSum(arr, sum-arr[i],i+1,dp);
            exc=subSetSum( arr,sum, i+1,dp);
        }else{
            exc=subSetSum( arr,sum, i+1,dp);
        }
        return  dp[i][sum]= inc||exc;
    }
    //Tabulatio
    //Timecomplexity=O(n*Sum)
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
    static boolean equalPartition(int N, int arr[]){
       //Find the sum of the elements of  the Array
       int sum=0;
       for(int ele:arr){
        sum+=ele;
       }
       //if sum is odd return false bcoz we can't devide the Array into equal sum with odd sum
       if(sum%2!=0){
        return false;
       } 
       sum=sum/2;
       boolean[][] dp=new  boolean[N+1][sum+1];
       return subSetSum(arr, sum,0,dp);
    }
    public static void main(String[] args) {
        int[] arr={1,5,11,5};
        System.out.println(equalPartition(arr.length, arr));
    }
}
