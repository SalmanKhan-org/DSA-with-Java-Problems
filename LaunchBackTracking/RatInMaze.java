package DSA_programs.LaunchBackTracking;
public class RatInMaze {
     public static void printPath(int sr, int sc, int destRow, int destCol, String str, int[][] arr){
        if(sr<0 || sc<0) return;

        if(sr>destRow || sc>destRow  ) return;
        if(sr== destRow && sc == destCol){
            System.out.println(str);
            return;
        }
        if(arr[sr][sc] == 0) return;
        if(arr[sr][sc] == -1) return;

        arr[sr][sc] = -1;
        //down
        printPath(sr+1, sc, destRow, destCol, str+"D", arr);
        //left
        printPath(sr, sc-1, destRow, destCol, str+"L", arr);
        //right
        printPath(sr, sc+1, destRow, destCol, str+"R", arr);
        //Up
        printPath(sr-1, sc, destRow, destCol, str+"U", arr);
        //Backtrack
        arr[sr][sc] = 1;
        
     }
        public static void main(String[] args) {
            int[][] arr = {{1,0,0,0},
                                {1,1,0,0},
                                {1,1,0,0},
                                {0,1,1,1}};
        int row = arr.length;
        int col = arr[0].length;
        //boolean[][] isVisited = new boolean[row][col];
        printPath(0, 0, row-1, col-1, "", arr);
          
    }
}
