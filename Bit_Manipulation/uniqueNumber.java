package DSA_programs.Bit_Manipulation;

import java.util.Scanner;

public class uniqueNumber {
    public static void main(String[] args) {
        int[] arr = {1,2,4,5,6,1,2,6,5};
        int unique =0;
        for(int n:arr){
            unique ^=n;
        }
        System.out.println("The unique element is:"+unique);
    }
}
