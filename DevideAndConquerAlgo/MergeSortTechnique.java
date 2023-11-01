package DSA_programs.DevideAndConquerAlgo;

public class MergeSortTechnique {
    //Time  complexity for this Sorting algorithm is = O(NlogN)
    //Space complexity = O(N)
        public static void mergeProcedure(int[] arr, int l, int mid , int r){
        int  i,j,k;
        int n1 = mid-l+1;
        int n2 = r-mid;
        //create a left SubArray and A Right SubArray
        int[] lSubArray = new int[n1];
        int[] rSubArray = new int[n2];
        //copy the element of left the left SubArray
        for( i=0;i<n1;i++){
            lSubArray[i] = arr[l+i];
        }
        //copy the element of the right SubArray
        for(j=0;j<n2;j++){
            rSubArray[j] = arr[mid+1+j];
        }
        //compare the element of the leftSubArray and right SubArray
        i=0;
        j=0;
        k=l;
        while(i<n1&&j<n2){
            if(lSubArray[i]<=rSubArray[j]){
                arr[k] = lSubArray[i];
                i++;
            }
            else{
                arr[k] = rSubArray[j];
                j++;
            }
            k++;
        }
        //Now Copy the remaining element of the right and left SubArray
        while(i<n1){
            arr[k] = lSubArray[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k] = rSubArray[j];
            j++;
            k++;
        }

    }
    public static void mergeSort(int[] arr,int i,int j) {
        //base case condition
        if(i<j){
            //1-> Devide the array by finding the mid valueinto two halves
            int mid = i+(j-i)/2;
            //2-> conquer the subArrays
            // first SubArray
            mergeSort(arr,i, mid);
            // Second SubArray
            mergeSort(arr, mid+1, j);

            //3-> Combine  the subProblems into solution of the original problem
            mergeProcedure(arr,i,mid,j);
        }
    }
        //print the Sorted Array
        public static void printF(int[] arr,int n){
            for(int i=0;i<n;i++){
                System.out.print(arr[i]+" ");
            }
        }
    public static void main(String[] args) {
        int[] arr ={90,65,34,85,12,23,32,11,10};
        System.out.println("The Array before Sorting:");
        printF(arr,arr.length);
        System.out.println("the Array after Sorting:");
        mergeSort(arr, 0, arr.length-1);
        printF(arr, arr.length);
    }
}
