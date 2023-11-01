package DSA_programs.LaunchRecursion;

import java.util.Scanner;

public class countStairsways {
    public static int countSteps(int n){
        if(n<=1){
            return n;
        }else{
            int steps  = countSteps(n-1)+countSteps(n-2);
            return steps;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the numbe of stairs:");
        int stairs = sc.nextInt();
        System.out.println(countSteps(stairs+1));
    }
}
