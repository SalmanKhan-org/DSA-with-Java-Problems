package DSA_programs.IntroToDP_dynamicProgramming;

public class LongestIncreasingSubSequences3 {
    //Time complexity=O(N^2)
    //Space complexity=O(N)
    static int solveTab(int n,int[] a){
        int[] curRow=new int[n+1];
        int[] nextRow=new int[n+1];
        for(int curr=n-1;curr>=0;curr--){
            for(int prev=curr-1;prev>=-1;prev--){
                int include=0;
                if(prev==-1||a[curr]>a[prev]){
                    include=1+nextRow[curr+1];
                }
                int exclude=nextRow[prev+1];
        
                curRow[prev+1]=Math.max(include,exclude);
            }
            nextRow=curRow;
        }
        return nextRow[0];
    }
    static int longestSubsequence(int size, int a[])
    {
        return solveTab(size,a);
    }
    public static void main(String[] args) {
        int[] a={2,3,5,6,8,4,3,2};
        System.out.println(longestSubsequence(a.length, a));
    }
}
