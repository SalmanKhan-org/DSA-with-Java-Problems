package DSA_programs.LaunchRecursion;

import java.util.Scanner;

public class isSortedArray {
    public static boolean isSorted(int i, int[] arr){
        if(i== arr.length-1){
            return true;
        }
        if(arr[i] >=arr[i+1])return false;

        return isSorted(i+1, arr);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the Array:");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the element of the Array:");
        for(int i=0;i<size;i++){
            arr[i] = sc.nextInt();
        }
        int i=0;
        System.out.println(isSorted(i,arr));
    }
}
