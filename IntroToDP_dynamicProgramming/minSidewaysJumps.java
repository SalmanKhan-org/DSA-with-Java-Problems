package DSA_programs.IntroToDP_dynamicProgramming;

import java.util.Arrays;

public class minSidewaysJumps {
    //Approach-1 recursive/Brute force approach\
    //Time complexity=O(3^N*3)
    public static int minjumps(int[] obstacles,int pos,int curlane){
        //base case
        if(pos==obstacles.length-1){
            return 0;
        }
        //if no obstacle on next pos in same lane
        if(obstacles[pos+1]!=curlane){
            return minjumps(obstacles,pos+1,curlane);
        }else{
            int ans=Integer.MAX_VALUE;
            for(int i=1;i<=3;i++){
                if(curlane!=i&&obstacles[pos]!=i){
                    ans=Math.min(ans,1+minjumps(obstacles,pos,i));
                }
            }
            return ans;
        }
    }
    //Approach-2 recursion+memoization
    // Time compelxity=O(3*N)
    //Space complexity=O(4*N*M) n for recursion and M for positions
    public static  int minjumpsMemo(int[] obstacles,int pos,int curlane,int[][] dp){
        //base case
        if(pos==obstacles.length-1){
            return 0;
        }
        if(dp[curlane][pos]!=-1){
            return dp[curlane][pos];
        }
        //if no obstacle on next pos in same lane
        if(obstacles[pos+1]!=curlane){
            return minjumpsMemo(obstacles,pos+1,curlane,dp);
        }else{
            int ans=Integer.MAX_VALUE;
            for(int i=1;i<=3;i++){
                if(curlane!=i&&obstacles[pos]!=i){
                    ans=Math.min(ans,1+minjumpsMemo(obstacles,pos,i,dp));
                }
            }
            return dp[curlane][pos]=ans;
        }
    }

    public static int minSideJumps(int[] obstacles) {
        int n=obstacles.length;
        int[][] dp=new int[4][n+1];
        // for(int[] arr:dp)
        //     Arrays.fill(arr,-1);
        // return minjumpsMemo(obstacles,0,2,dp);


        //Approach-3 Tabulation Method
        //Time complexity=O(N)
        //Space complexity=O(1)
        dp[0][n-1]=0;
        dp[1][n-1]=0;
        dp[2][n-1]=0;
        dp[3][n-1]=0;

        for(int pos=n-2;pos>=0;pos--){
            for(int curlane=1;curlane<=3;curlane++){
                if(obstacles[pos+1]!=curlane){
                    dp[curlane][pos]=dp[curlane][pos+1];
                }else{
                    int ans=Integer.MAX_VALUE;
                    for(int i=1;i<=3;i++){
                        if(curlane!=i&&obstacles[pos]!=i){
                        ans=Math.min(ans,1+dp[i][pos+1]);
                    }
                }
                dp[curlane][pos]=ans;
            }
        }
        }
        return Math.min(dp[2][0],Math.min(1+dp[1][0],1+dp[3][0]));

    }
    public static void main(String[] args) {
        int[] obstacles={0,1,2,3,0};
        System.out.println(minSideJumps(obstacles));
        
    }
}
