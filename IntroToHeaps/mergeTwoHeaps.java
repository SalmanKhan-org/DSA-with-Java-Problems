package DSA_programs.IntroToHeaps;

import java.util.Arrays;

public class mergeTwoHeaps {
    static  void heapify(int arr[], int n, int i)
    {
        int largest=i;
        int leftchild=2*i+1;
        int rightchild=2*i+2;
        if(leftchild<n && arr[largest]<arr[leftchild]){
            largest=leftchild;
        }
        if(rightchild<n && arr[largest]<arr[rightchild]){
            largest=rightchild;
        }
        if(largest!=i){
            int temp=arr[i];
            arr[i] = arr[largest];
            arr[largest]= temp;
            heapify(arr,n,largest);
        }
    }
    public static void mergeTwoArrays(int[] a,int[] b,int[] mergeArray,int n,int m){
        int i=0;
        for(;i<n;i++){
            mergeArray[i]=a[i];
        }
        for(int j=0;j<m;j++){
            mergeArray[i++]=b[j];
        }
    }
    public static int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        int[] mergeArray=new int[m+n];
        mergeTwoArrays(a,b,mergeArray,n,m);
        for(int i=mergeArray.length/2;i>=0;i--){
            heapify(mergeArray,mergeArray.length,i);
        }
        return mergeArray;
    }
    public static void main(String[] args) {
        int[] a={10,5,6,2};
        int[] b={12,7,9};
        int[] mergeArray=mergeHeaps(a, b, a.length, b.length);
        System.out.println(Arrays.toString(mergeArray));
    }
}
