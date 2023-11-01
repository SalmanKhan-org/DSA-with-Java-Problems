package DSA_programs.IntroToDP_dynamicProgramming;

public class uniqueBSTs2 {
    public int numTrees(int n) {
        int[] dp=new int[n+1];
        // Arrays.fill(dp,-1);
        // return uniqueBst(n,dp);

        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<=n;i++){
            int ans=0;
            for(int j=0;j<i;j++){
                ans+=dp[j]*dp[i-j-1];
            }
            dp[i]=ans;
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n=4;
        System.out.println(new uniqueBSTs2().numTrees(n));
    }
}
