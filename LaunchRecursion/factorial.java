package DSA_programs.LaunchRecursion;

import java.util.Scanner;

public class factorial {
    public static int fact(int n){
        if(n==0||n==1){
            return 1;
        }else{
            return n*fact(n-1);
        }
    }
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         System.out.println("Enter the number:");
         int num = sc.nextInt();
         int result = fact(num);
         System.out.println("The factorial of "+num+" is :"+result);
    }
}
