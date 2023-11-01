package DSA_programs.DevideAndConquerAlgo;

import java.util.Arrays;

public class segregatePositiveNegativeEle {
    private static void mergeProcedure(int[] arr, int l, int mid, int h){
        int n1 = mid+1-l;
        int n2 = h-mid;
        int[] lSubArray = new int[n1];
        for(int  i=0;i<n1;i++){
            lSubArray[i] = arr[l+i];
        }
        int[] rSubArray = new int[n2];
        for(int  i=0;i<n2;i++){
            rSubArray[i] = arr[mid+1+i];
        }
        int i=0,j=0,k=l;
        while(i<n1&&lSubArray[i]<0){
            arr[k++] =  lSubArray[i++];
        }
        while(j<n2&&rSubArray[j]<0){
            arr[k++] = rSubArray[j++];
        }
        while(i<n1){
            arr[k++] = lSubArray[i++];
        }
        while(j<n2){
            arr[k++] = rSubArray[j++];
        }
    }
    private static void segregatePos_NegEle(int[] arr, int l , int h){
        if(l<h){
            int mid = l+(h-l)/2;
            segregatePos_NegEle(arr, l, mid);
            segregatePos_NegEle(arr, mid+1, h);
            mergeProcedure(arr,l,mid,h);
        }
    }
    public static void main(String[] args) {
        int[] arr = { 9, -3, 5, -2, -8, -6, 1, 3 };
        segregatePos_NegEle(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
