package DSA_programs.LaunchBackTracking;

public class NQueenSolution {
    public static void printNQueen(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(".................................................");
    }
    public static boolean isSafe(int[][] arr, int row, int col) {
        //horizontal
        for(int i=0;i<arr.length;i++){
            if(arr[row][i] == 1){
                return false;
            }
            if(arr[i][col]==1) return false;
        }
        //vertical
        // for(int i=0;i<arr.length;i++){
        //     if(arr[i][col] == 1){
        //         return false;
        //     }
        // }
        //upper left diagonal
        for(int i=row,j=col;i>=0&&j>=0;i--,j--){
            if(arr[i][j] == 1){
                return false;
            }
        }
        //uper right diagonal
        for(int i= row,j=col;i>=0&&j<arr.length;i--,j++){
            if(arr[i][j] == 1){
                return false;
            }
        }
        //lower left diagonal
        for(int i= row,j=col;i<arr.length&&j>=0;i++,j--){
            if(arr[i][j] == 1){
                return false;
            }
        }
        //lower right diagonal
        for(int i=row,j=col;i<arr.length&&j<arr.length;i++,j++){
            if(arr[i][j] == 1){
                return false;
            }
        }
        return true;
    }
    public static void NQueenSolver(int[][] arr, int row, int n){
        if(row == n){
            printNQueen(arr);
            return;
        }
        for(int col=0;col<arr[0].length;col++){
            if(isSafe(arr, row, col) == true){
                arr[row][col] = 1;
                NQueenSolver(arr, row+1, n);
            }
            arr[row][col] = 0;
        }
    }
    public static void main(String[] args)   {
        int n=4;
        int[][] arr = new int[n][n];
        NQueenSolver(arr, 0,n);
    }
}