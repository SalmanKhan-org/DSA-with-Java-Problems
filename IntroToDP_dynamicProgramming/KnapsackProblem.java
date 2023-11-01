package DSA_programs.IntroToDP_dynamicProgramming;

import java.util.Arrays;

public class KnapsackProblem {
    //using recursion
    //time complexity=O(2^N)
    //space complexity=O(N)
    static int maxValue(int capacity,int[] wt,int[] val,int index){
        //base case
        //if we have only one element then we have to check whether  we have the maxCapcity
        //to pick this value or not if we have  then pick else leave it
        if(index==0){
            if(wt[0]<=capacity){
                return val[0];
            }else{
                return 0;
            }
        }
        int include=0;
        //call for include the value
        if(wt[index]<=capacity){
            include=val[index]+maxValue(capacity-wt[index],wt,val,index-1);
        }
        //call for exclude the value
        int exclude=0+maxValue(capacity,wt,val,index-1);
        //now we have two answers one is of include and another one  is of exclude
        //we  have to choose the maximum among  them
        return Math.max(include,exclude);
        
    }
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        return  maxValue(W,wt,val,n-1); 
    } 
     //Using recursion+Memoization
     //time complexity=O(N);
     //space somplexity=O(2N);
     static int maxValueMemo(int capacity,int[] wt,int[] val,int index, int[][] dp){
        //base case
        //if we have only one element then we have to check whether  we have the maxCapcity
        //to pick this value or not if we have  then pick else leave it
        if(index==0){
            if(wt[0]<=capacity){
                return val[0];
            }else{
                return 0;
            }
        }
        //check if our answer is already calculated or not
        if(dp[index][capacity]!=-1){
            return dp[index][capacity];
        }
        int include=0;
        //call for include the value
        if(wt[index]<=capacity){
            include=val[index]+maxValueMemo(capacity-wt[index],wt,val,index-1,dp);
        }
        //call for exclude the value
        int exclude=0+maxValueMemo(capacity,wt,val,index-1,dp);
        //now we have two answers one is of include and another one  is of exclude
        //we  have to choose the maximum among  them
        dp[index][capacity]= Math.max(include,exclude);
        return dp[index][capacity];
        
    }
    static int knapSackMemo(int W, int wt[], int val[], int n) 
    { 
        int[][] dp=new int[n][W+1];
        for(int[] dp1:dp){
            Arrays.fill(dp1,-1);
        }
        return maxValueMemo(W,wt,val,n-1,dp);
    } 
     //Using tabulation
     static int maxValueTab(int capacity,int[] wt,int[] val,int n){
        int[][] dp=new int[n][capacity+1];
        
        //Analyze base case whole 0th  row
        for(int w=wt[0];w<=capacity;w++){
            if(wt[0]<=capacity){
                dp[0][w]=val[0];
            }else{
                dp[0][w]=0;
            }
        }
        //step2
        for(int index=1;index<n;index++){
            for(int w=0;w<=capacity;w++){
                 int  include=0;
                if(wt[index]<=w){
                     include=val[index]+dp[index-1][w-wt[index]];
                }
                int exclude=0+dp[index-1][w];
                dp[index][w]=Math.max(include,exclude);
            }
        }
        return  dp[n-1][capacity];
    }
    static int knapSackTab(int W, int wt[], int val[], int n) 
    { 
       return maxValueTab(W,wt,val,n);
    } 
     //space optimization
     static int maxValueSpace(int[] weight,int[] value,int n,int capacity){
        int[] curr=new int[capacity+1];
        //base case
        for(int i=weight[0];i<=capacity;i++){
             if(weight[0]<=capacity){
                curr[i]=value[0];
            }else{
                curr[i]=0;
            }
        }
        for(int i=1;i<n;i++){
            for(int wt=capacity;wt>=0;wt--){
                int include=0;
                if(weight[i]<=wt){
                    include=value[i]+curr[wt-weight[i]];
                }    
                int exclude=0+curr[wt];
                curr[wt]=Math.max(include,exclude);
            }
        }
        return curr[capacity];
    }

    static int knapsackSpace(int[] weight, int[] value, int n, int maxWeight) {
       return maxValueSpace(weight,value,n,maxWeight);
    }
    public static void main(String[] args) {
        int wt[]={1,2,4,5};
        int[] val={5,4,8,6};
        int W=5;
        System.out.println(knapSack(W, wt, val, wt.length));
    }
}
