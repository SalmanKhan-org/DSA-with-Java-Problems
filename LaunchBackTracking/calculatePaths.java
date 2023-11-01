package DSA_programs.LaunchBackTracking;

public class calculatePaths {
    public static void printPaths(int CR, int CC,int destRow, int destCol,int[][] arr, String str){
        if(CR<0 || CC<0) return;
        if( CR>destRow || CC >destCol) return;
        if(CR == destRow &&CC == destCol){
            System.out.println(str);
            return;
        }
        if(arr[CR][CC] == 0) return;
        if(arr[CR][CC] == -1) return;
        arr[CR][CC] = -1;
        printPaths(CR+1, CC, destRow, destCol,arr, str+"D");
        printPaths(CR, CC+1, destRow, destCol,arr, str+"R");
        printPaths(CR-1, CC, destRow, destCol,arr, str+"U");
        printPaths(CR, CC-1, destRow, destCol,arr, str+"L");
        arr[CR][CC] = 1;
    }
    public static void main(String[] args) {
        int[][] arr = {{1,0,0,1},
                            {1,1,0,0},
                            {1,1,0,0},
                            {1,1,1,1}};
        int m = arr.length;
        int n = arr[0].length;
        printPaths(0, 0, m-1, n-1,arr, "");
    }
}
