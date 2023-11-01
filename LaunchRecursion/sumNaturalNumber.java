package DSA_programs.LaunchRecursion;

import java.util.Scanner;

public class sumNaturalNumber {
    public static int sum( int n){
        if(n<=1){
            //Sum +=i;
            //System.out.println("The sum of "+n+" numbers:"+Sum);
            return 1;
        }else{
            return n+sum(n-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to calculate the sum:");
        int num = sc.nextInt(); 
        System.out.println(sum(num));
    }
}
