package DSA_programs.IntroTo_1DArrays;

import java.util.Arrays;

public class MoveNegativeAndPositiveNums {
    //Using two pointer approach
    public static void main(String[] args) {
                int arr[] = {3,5,-1,-5,6,-8,7,4,-7};
                int n = arr.length;
                int left = 0,right=n-1;
                while(left<=right){
                    if(arr[left]<0&&arr[right]<0){
                        left++;
                    }else if(arr[left]>0 && arr[right]<0){
                        int temp = arr[right];
                        arr[right] = arr[left];
                        arr[left] = temp;
                        left++;
                        right--;
                    }else if(arr[right]>0 &&arr[left]>0){
                        right--;
                    }else{
                        left++;
                        right--;
                    }
                }
                System.out.println("The after Rearrange the elements is:"+Arrays.toString(arr));
            }
}
