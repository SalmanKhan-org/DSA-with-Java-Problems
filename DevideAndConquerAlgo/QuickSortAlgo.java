package DSA_programs.DevideAndConquerAlgo;

public class QuickSortAlgo {
    //Best Time And Average time complexity:O(NlogN);
    //worst time complexity:O(n*n);
    //Space complexity = O(1) because we are not using any extra space for sorting the Array
    private static int partition(int[] arr, int l, int h){ 
        //declare the pivot element
        int i = l;
        int pivot =arr[i];
        for(int j=i+1;j<=h;j++){
            //compare the pivot element and j point to bigger element than pipvot
            //i point to smaller element than pivot
            if(arr[j]<=pivot){
                i++;
                //swap between i and j
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //swap between the element pointed by i and pivot
        int temp = arr[l];
        arr[l] = arr[i];
        arr[i] = temp;

       return i;
    }
    private static void quickSort(int[] arr, int l, int h){
        if(l<h){
            //find the middle element using partition algorithm from where we will devide the array
            int m  = partition(arr,l,h);
            //left SubArray
            quickSort(arr, l, m-1);
            //right SubArray
            quickSort(arr,m+1,h);
        }
    } 
    private static void printF(int[] arr, int n){
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ->");
        }
    }
    public static void main(String[] args) {
        int[] arr = {10,20,15,30,12,11,13};
        int n = arr.length;
        System.out.println("The array before Sorting:");
        printF(arr, n);
        System.out.println("\nThe Array after Sorting:");
        quickSort(arr, 0, n-1);
        printF(arr, n);
    }
}
