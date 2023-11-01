package DSA_programs.Bit_Manipulation;

import java.util.Scanner;

public class get_set_clear_updateBit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number:");
        int n = sc.nextInt();
        System.out.println("Enter the position of the Bit:");
        int pos = sc.nextInt();
        //update bit
         



        //clear bit
        // int bitMask = 1<<pos;
        // int clearNum = ~(bitMask)&n;
        // System.out.println(clearNum);



        //Set the bit
        // int bitMaskOR =  (1<<pos)|n;
        // System.out.println(bitMaskOR);


        //Get the bit
        // int bitMask = 1<<pos;
        // if((bitMask & n) == 0){
        //     System.out.println("The "+pos+"rd bit was zero:");
        // }else{
        //     System.out.println("The "+pos+"rd bit was one:");
        // }
    }
}
