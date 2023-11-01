package DSA_programs.IntroToDP_dynamicProgramming;
import java.util.*;
public class maxPathSumInMatrix {
    //recursion+MemoIzation
    //Time complexity=O(N*N)
    //Space complexity=O(N*N)
    static int maxSum(int r,int c,int N,int[][] mat,int[][] dp){
        //invalid index
        if(c<0||c>=N){
            return -1;
        }
        //base case
        if(r==N-1){
            return mat[r][c];
        }
        if(dp[r][c]!=-1){
            return dp[r][c];
        }
        dp[r][c] =mat[r][c]+Math.max(maxSum(r+1,c,N,mat,dp),Math.max(maxSum(r+1,c-1,N,mat,dp),maxSum(
            r+1,c+1,N,mat,dp)));
        return dp[r][c];
    }
    static int maximumPath(int N, int Matrix[][])
    {
        int[][] dp=new  int[N][N];
        for(int[] ar:dp){
            Arrays.fill(ar,-1);
        }
        //find maximum in the first row
        int res=Integer.MIN_VALUE;
        for(int c=0;c<N;c++){
            res=Math.max(res,maxSum(0,c,N,Matrix,dp));
        }
        return res;
        
    }
    //using Tabulation mathod
    //Time complexity=O(N*N)
    //Space complexity=O(1)
    static int solveTab(int N,int[][] mat){
        for(int i=1;i<N;i++){
            for(int j=0;j<N;j++){
                //case:1 to reach at first column we have only two way
                if(j==0){
                    mat[i][j]+=Math.max(mat[i-1][j],mat[i-1][j+1]);
                }else if(j==N-1){  //case:2 to reach at last column we  have only two way
                    mat[i][j]+=Math.max(mat[i-1][j-1],mat[i-1][j]);
                }else{
                    mat[i][j]+=Math.max(mat[i-1][j],Math.max(mat[i-1][j-1],mat[i-1][j+1]));
                }
            }
        }
        //find the  maximum from the last row
        int max=Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            max=Math.max(max,mat[N-1][i]);
        }
        return max;
    }
    public static void main(String[] args) {
        int[][] mat={
                           {23,44},
                           {34,54}
                          };
         System.out.println(maximumPath(mat.length, mat));
    }
}
