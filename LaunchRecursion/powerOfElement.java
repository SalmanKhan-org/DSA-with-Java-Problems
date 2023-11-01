package DSA_programs.LaunchRecursion;

import java.util.Scanner;
import java.math.*;

public class powerOfElement{
   public static BigInteger pow(BigInteger a, int b){
    if(b==1){
        return a;
    }else{
        BigInteger power = pow(a,b/2);
        BigInteger finalpower = power.multiply(power);
        if(b%2 == 0){
            return finalpower;
        }else{
            return a.multiply(finalpower);
        }
    }
   }
        //Time complexity = O(n);
        //Space complexity = O(n);
        // if(b==1){
        //     return a;
        // }else{
        //     return a*pow(a, b-1);
        // }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the base:");
        BigInteger base = sc.nextBigInteger();
        System.out.println("Enter the exponent:");
        int expo = sc.nextInt();
        BigInteger power = pow(base,expo);
        System.out.println(base+"^"+expo+":::"+power);
        }       
}
