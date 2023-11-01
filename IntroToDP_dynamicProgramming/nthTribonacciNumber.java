package DSA_programs.IntroToDP_dynamicProgramming;

import java.util.Arrays;

public class nthTribonacciNumber {
    //Approach-1 Recursive 
    //Time complexity=3^n
    private static  int nthNumber(int n){
        if(n==0||n==1){
            return n;
        }
        if(n==2){
            return 1;
        }
        return nthNumber(n-1)+nthNumber(n-2)+nthNumber(n-3);
    }
    //Approach-2 recursion +MemoIzation
    //Time complexity=O(n)

    private static  int nthNumberMemo(int n,int[] dp){
        if(n==0||n==1){
            return n;
        }
        if(n==2){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        return dp[n]=nthNumberMemo(n-1,dp)+nthNumberMemo(n-2,dp)+nthNumberMemo(n-3,dp);
    }
    //Approach-3 using tabulation (bottom-up)
    private static  int nthNumberTab(int n){
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
        return dp[n];
    }
    //Approach-4
    //Space optimization
    //Time complexity=O(n);
    //Space complexity=O(1)
    private static  int nthNumberSpace(int n){
        int prev0=0;
        int prev1=1;
        int prev2=1;
        for(int i=3;i<=n;i++){
            int curr=prev2+prev1+prev0;
            prev0=prev1;
            prev1=prev2;
            prev2=curr;
        }
        return prev2;
    }
    public static void main(String[] args) {
        int n=25;
        System.out.println(nthNumber(25));
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(nthNumberMemo(n,dp));
        System.out.println(nthNumberTab(n));
        System.out.println(nthNumberTab(n));
    }
}
