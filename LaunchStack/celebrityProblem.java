package DSA_programs.LaunchStack;

import java.util.Stack;

public class celebrityProblem {
    private static boolean knows(int[][] M,int a, int b){
        if(M[a][b]==1) return true;

        return false;
    }
    private static int isCelebrity(int[][] M,int N){
        Stack<Integer> s = new  Stack<>();//stack for find the possible candidate as a celebrity
        for(int i=0;i<N;i++){
            s.push(i);
        }
        int n=N;
        while(n!=1){
            int a=s.pop();
            int b=s.pop();
            if(knows(M,a,b)){
                s.push(b);
            }else{
                s.push(a);
            }
            n--;
        }
        int ele = s.pop();
        //System.out.println(ele);
        int rowZero=0;
        int colOne=0;
        for(int i=0;i<N;i++){
            if(M[ele][i]==0){
                rowZero++;
            }
            if(M[i][ele]==1) colOne++;
        }
        if(rowZero==N && colOne==N-1)  return ele;

        return -1;
    }
    public static void main(String[] args) {
        int[][]   M = {{0,1,0},
                            {0,0,0},
                           {0,1,0}};
        System.out.println(isCelebrity(M, M.length));                   
    }
}
