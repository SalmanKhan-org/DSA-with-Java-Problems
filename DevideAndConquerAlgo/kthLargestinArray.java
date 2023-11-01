package DSA_programs.DevideAndConquerAlgo;

public class kthLargestinArray {
    private static int partition(int[] arr, int l , int h){
        int i=l;
        int pivot= arr[i];
        for(int j=i+1;j<=h;j++){
            if(arr[j]>pivot){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp  = arr[l];
        arr[l] = arr[i];
        arr[i] = temp;

        return i;
    }
    private static int kthLargest(int[] arr, int l, int h, int k){
        if(l<h){
            //find the middle element from where you have  to decide either you should go left or right SubArray
            int m = partition(arr,l,h);
            if(m==k-1){
                return arr[m];
            }else if(m<k-1){
                return  kthLargest(arr, m+1, h,k);
            }else{
                return kthLargest(arr, l, m-1, k);
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[]  arr = {10,4,5,8,6,11,26};
        int k = 3;
        System.out.println("The "+k+"th largest element in the given array:"+kthLargest(arr, 0, arr.length-1, k));

    }
}
