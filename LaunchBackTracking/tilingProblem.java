package DSA_programs.LaunchBackTracking;

import java.util.Scanner;

public class tilingProblem {
    public static int getWays(int n){
        if(n<=3){
            return n;
        }
        return getWays(n-1)+getWays(n-2);

    } 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number Size of board:");
        int size = sc.nextInt();
        System.out.println("The ways for board Size "+(2*size)+":::"+getWays(size));
    }
}
