package DSA_programs.IntroToDP_dynamicProgramming;

public class MatrixChainMultiply2 {
    static int matrixMultiplication(int N, int arr[])
    {
        int[][] dp=new  int[N][N];
    
        for(int i=N-1;i>=1;i--){
            for(int j=i+1;j<N;j++){
                int mini=Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                     int ans=arr[i-1]*arr[k]*arr[j]+dp[i][k]+dp[k+1][j];
                    mini=Math.min(mini,ans);
                }
                dp[i][j]=mini;
            }
        }
        return dp[1][N-1];
    }
    public static void main(String[] args) {
        int[] arr={10,20,30,40,50};
        System.out.println(matrixMultiplication(arr.length, arr));
    }
}
