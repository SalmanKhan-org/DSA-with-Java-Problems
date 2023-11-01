package DSA_programs.LaunchRecursion;

import java.util.Scanner;


public class printPossiblePaths {
    public static void printPaths(int curPos, int dest, String str){
        if(curPos > dest){
            return;
        }
        if(curPos == dest){
            System.out.println(str);
            return;
        }
        printPaths(curPos+1,dest,str+1);
        printPaths(curPos+2,dest,str+2);
        printPaths(curPos+3,dest,str+3);
        printPaths(curPos+4,dest,str+4);
        printPaths(curPos+5,dest,str+5);
        printPaths(curPos+6,dest,str+6);
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the current position:");
        int curPos = sc.nextInt();
        System.out.println("Enter the destination point:");
        int dest = sc.nextInt();
        printPaths(curPos,dest,"");
    }
}