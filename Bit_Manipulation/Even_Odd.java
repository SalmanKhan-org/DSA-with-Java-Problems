package DSA_programs.Bit_Manipulation;

import java.util.Scanner;

public class Even_Odd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number:");
        int num = sc.nextInt();
        if((num & 1) == 1){
            System.out.println("The number is odd:");
        }else{
            System.out.println("The number is Even:");
        }
    }
}
