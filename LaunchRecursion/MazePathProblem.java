package DSA_programs.LaunchRecursion;

public class MazePathProblem {
    public static void printPaths(int CR, int CC,int destRow,int destCol, String str){
        if(CR >destRow|| CC > destCol)  {    
        return;  
        }
        if(CR == destRow && CC == destCol){
            System.out.println(str);
            return;
        }
        printPaths(CR, CC+1,destRow,destCol, str+"H");
        printPaths(CR+1, CC,destRow,destCol, str+"V");
}
    public static void main(String[] args) {
        int[][] arr = {{1,2,3,5},
                           {4,5,6,4},
                           {7,8,9,8}};
        int m = arr.length;
        int n = arr[0].length;
        printPaths(0, 0,m-1,n-1, "");
    }
}
