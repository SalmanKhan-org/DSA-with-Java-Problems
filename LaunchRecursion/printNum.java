package DSA_programs.LaunchRecursion;

import java.util.Scanner;

public class printNum { 
    public static int printfibo(//int a, int b, 
    int n){
        if(n==0||n==1){
            return n;
        }else{
            //int c = a+b;
            //System.out.print(c+" ");
            //printfibo(b,c,n-1); 
            return printfibo(n-1)+printfibo(n-2);
        }
    }
    //public static int printNumber(int n){
        // if(n==0){
        //     return n;
        // }else{
        //    return n+printNumber(n-1);
        // }
    //} 
    public static void main(String[] args) {
        //int a=0,b=1,n=9;
        //System.out.print(a+" ");
        //System.out.print(b+" ");
        //printfibo(a,b,n-2);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number:");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.print(printfibo(i)+" ");
        }




        // int n=5;
        // System.out.println(printNumber(n));

    }
}
