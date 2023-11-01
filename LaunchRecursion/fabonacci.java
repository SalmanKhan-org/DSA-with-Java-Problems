package DSA_programs.LaunchRecursion;

import java.util.Scanner;

public class fabonacci {
    public static int printfibo( int n){
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }
        else{
            int c =
        //System.out.print(c+" ");
        return printfibo(n-1)+printfibo(n-2);
    }
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number:");
        int num = sc.nextInt();
        int n1 =0,n2=1;
        System.out.print(n1+" ");
        System.out.println(n2+" ");
        printfibo(num-2);
        // for(int i=0;i<num;i++){
        //     System.out.print(printfibo(i)+" ");
        // }
    }
}
