package DSA_programs.GreedyAlgorithm;

import java.util.Scanner;

public class canPlaceFlower {
        public static boolean  canPlaceFlowers(int[] flowerbed, int n) {
            if(n==0) return true;
            int m=flowerbed.length;
            for(int i=0;i<m;i++){
                if(flowerbed[i]==0&&(i==0||flowerbed[i-1]==0)&&(i==m-1||
                flowerbed[i+1]==0)){
                    flowerbed[i]=1;
                    if (--n == 0)
                     return true;
                }
            }
            return false;
        }
        public static void main(String[] a) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the size of the Array:");
            int n = sc.nextInt();
            int[] arr=new int[n];
            System.out.println("Enter the elements of the Array:");
            for(int i=0;i<n;i++){
                arr[i] =sc.nextInt();
            }
            System.out.println("Enter the number of the flowers:");
            int f = sc.nextInt();
            System.out.println(canPlaceFlowers(arr, f));

        }
}
