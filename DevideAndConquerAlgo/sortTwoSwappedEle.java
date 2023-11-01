package DSA_programs.DevideAndConquerAlgo;

import java.util.Arrays;

//Given  a sorted array of integer containing two swapped element,sort the array in linear time complexity
public class sortTwoSwappedEle {
    private static void sortSwappedEle(int[] arr, int n){
        int prev=arr[0],x=-1,y=-1;
        for(int i=1;i<n;i++){
            if(prev>arr[i]){
                if(x==-1){
                    x=i-1;
                    y=i;
                }else{
                    y=i;
                }
            }
            prev = arr[i];
        }
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {3,8,6,7,5,9,10};
        sortSwappedEle(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
    
}
