package DSA_programs.IntroToDP_dynamicProgramming;
import java.util.*;
public class minSumInTriangleMatrix {
    //Approach-1 recursion
    //Time complexity=O(2^row*col)
    private  static int minPathSum(int row,int col,int n,ArrayList<ArrayList<Integer>> grid){
        //Base case  
        if(row==grid.size()-1){
            return grid.get(row).get(col);
        }
        int down=grid.get(row).get(col)+minPathSum(row+1, col, n, grid);
        int  diagonal=grid.get(row).get(col)+minPathSum(row+1, col+1, n, grid);

        return Math.min(down,diagonal);
    }
    //Approach-2 Recursion+MemoIzation
    //Time complexity=O(row*col)
    private  static int minPathSumMemo(int row,int col,ArrayList<ArrayList<Integer>> grid,int[][] dp){
        //Base case  
        if(row==grid.size()-1){
            return grid.get(row).get(col);
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int down=grid.get(row).get(col)+minPathSumMemo(row+1, col, grid,dp);
        int  diagonal=grid.get(row).get(col)+minPathSumMemo(row+1, col+1, grid,dp);

        return dp[row][col]=Math.min(down,diagonal);
    }
    //Approach-3 Using Tabulation
    private static int solveTab(ArrayList<ArrayList<Integer> >grid){
        int n=grid.size();
        int m=grid.get(n-1).size();
        int[][] dp=new int[n][m];
        for(int i=0;i<m;i++){
            dp[n-1][i]=grid.get(n-1).get(i);
        }
        for(int i=n-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                int down=grid.get(i).get(j)+dp[i+1][j];
                int diagonal=grid.get(i).get(j)+dp[i+1][j+1];
                dp[i][j]=Math.min(down,diagonal);
            }
        }
        return dp[0][0];
    }
    //Approach-4  Space optimization
    //Time complexity=O(N*M)
    //Space complexity=O(N)
    private static int solveSpace(ArrayList<ArrayList<Integer> >grid){
        int n=grid.size();
        int m=grid.get(n-1).size();
        int[] prev=new int[n];
        for(int i=0;i<m;i++){
            prev[i]=grid.get(n-1).get(i);
        }
        for(int i=n-2;i>=0;i--){
            int[] curr=new int[i+1];
            for(int j=i;j>=0;j--){
                int down=grid.get(i).get(j)+prev[j];
                int diagonal=grid.get(i).get(j)+prev[j+1];
                curr[j]=Math.min(down,diagonal);
            }
            prev=curr;
        }
        return prev[0];
    }
    public static int minimizeSum(int n, ArrayList<ArrayList<Integer>> grid) {
        //return minPathSum(0,0,n, grid);
        int[][] dp=new int[n][grid.get(n-1).size()];
        for(int[] ar:dp){
            Arrays.fill(ar,-1);
        }
        return minPathSumMemo(0,0,grid,dp);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=4;
        ArrayList<ArrayList<Integer>> grid = new  ArrayList<ArrayList<Integer>>(n);
        System.out.println("Enter the element in the List:");
        for(int i=0;i<n;i++){
            ArrayList<Integer> ar=new ArrayList<>();
            for(int j=0;j<=i;j++){
                int x=sc.nextInt();
                ar.add(x);
            }
            grid.add(ar);
        }
        System.out.println(minimizeSum(n, grid));
    }
}
