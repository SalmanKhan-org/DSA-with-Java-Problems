package DSA_programs.LaunchBackTracking;

public class SudokuSolver {
    public static void printSudoku(int[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
public static boolean isSafe(int[][] board, int row, int col, int num){
    for(int i=0;i<board[0].length;i++){
        if(board[row][i] == num){// for column
            return false;
        }
        if(board[i][col] == num){//for row
            return false;
        }
    }
    int strtRow = (row/3)*3;
    int strtCol = (col/3)*3;
    for(int i=strtRow;i<strtRow+3;i++){
        for(int j=strtCol;j<strtCol+3;j++){
            if(board[i][j] == num){
                return false;
            }
        }
    }
    return true;
}
    public static boolean solveSudoku(int[][] board, int row, int col){
        if(row == board.length){
            printSudoku(board);
            return true;
        }
        int nRow = 0;
        int nCol = 0;
        if(col == board[0].length-1){
            nRow = row+1;
            nCol = 0;
        }else{
            nRow = row;
            nCol = col+1;
        }
        if(board[row][col] != 0){
            if(solveSudoku(board, nRow, nCol))
            return true;
        }else{
            for(int po=1;po<=9;po++){
                if(isSafe(board,row,col,po)==true){
                    board[row][col] = po;
                    if(solveSudoku(board, nRow, nCol)){
                        return true;
                    }else{
                        board[row][col] = 0;
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int board[][] = {{0,1,0,0,2,7,8,6,5},
                                {6,0,0,9,0,5,2,0,3},
                                {0,5,0,6,8,0,0,0,1},
                                {1,0,0,5,0,0,0,0,7},
                                {4,7,9,0,0,0,0,0,9},
                                {5,0,8,0,0,4,9,1,2},
                                {0,0,0,0,0,1,6,0,9},
                                {0,9,0,0,0,0,3,7,0},
                                {7,2,0,3,0,0,0,0,8}};
    solveSudoku(board, 0, 0);
    }
}