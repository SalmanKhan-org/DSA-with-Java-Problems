package DSA_programs.LaunchRecursion;

import java.util.Scanner;

public class combOfBalBracket {
    public static void  printBalBracket(int n, int OB, int CB, String str){
        if(OB == n && CB ==n){
            System.out.println(str);
            return;
        }
        if(OB<n){
            printBalBracket(n, OB+1, CB, str+"(");
        }
        if(OB > CB){
            printBalBracket(n, OB, CB+1, str+")");
        }
    } 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of paranthesis:");
        int brac = sc.nextInt();
        printBalBracket(brac,0,0,"");
    }
}