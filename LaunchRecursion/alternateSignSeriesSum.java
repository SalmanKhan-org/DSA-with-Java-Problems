package DSA_programs.LaunchRecursion;

import java.util.Scanner;

public class alternateSignSeriesSum {
    public static int alternateSignSum(int n){
        if(n==0){
            return 0;
        }else{
            if(n%2==0){
                return alternateSignSum(n-1)-n;
            }else{
                return alternateSignSum(n-1)+n;
            }
        }
    } 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number:");
        int num = sc.nextInt();
        int result=  alternateSignSum(num);
        System.out.println("the sum is:"+result);

    }
}
