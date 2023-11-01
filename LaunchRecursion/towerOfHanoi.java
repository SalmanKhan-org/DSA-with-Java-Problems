package DSA_programs.LaunchRecursion;

import java.util.Scanner;

public class towerOfHanoi {
    public static void TOH(int n, String S,String H, String D){
        //base case
        if(n == 1){
            System.out.println("Move a Disk from "+S+" to "+D);
            return;
        }
        TOH(n-1,S,D,H);
        System.out.println("Move a Disk from "+S+" to "+D);
        TOH(n-1,H,S,D);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
    }
}
