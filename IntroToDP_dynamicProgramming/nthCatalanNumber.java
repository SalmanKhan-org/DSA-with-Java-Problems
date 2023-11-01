package DSA_programs.IntroToDP_dynamicProgramming;

public class nthCatalanNumber {
    static int MOD=1000000007;
    public static int findCatalan(int n) {
        long[] dp=new long[n+1];
        
        dp[0]=1;
        dp[1]=1;
        
        for(int i=2;i<=n;i++){
            dp[i]=0;
            for(int j=0;j<i;j++)
                dp[i]=(long)(dp[i]+(long)(dp[j]*dp[i-j-1])%MOD)%MOD;
        }
        return (int)(dp[n]%MOD);
    }
    public static void  main(String[] args){
        int n=179;
        System.out.println("The "+n+"th catalan number is:"+findCatalan(n));
    }
}
