package DSA_programs.IntroTo_1DArrays;
import java.util.*;
//Using Dutch national Flag Algorithm
public class MovePositiveAnsNegativeNums2_DNF {
     public static void main(String[] args) {
        int arr[] = {3,-1,-2,4,-5,-6};
        int n = arr.length;
        int lo=0,hi=n-1;
        while(lo<=hi){
            if(arr[lo]<0){
                lo++;
            }else if(arr[lo]>0){
                int temp = arr[lo];
                arr[lo] = arr[hi];
                arr[hi] = temp;
                hi--;
            }
        }
        System.out.println("The array after rearrangement the elements = "+Arrays.toString(arr));
    }
}
