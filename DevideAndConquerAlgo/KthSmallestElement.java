package DSA_programs.DevideAndConquerAlgo;

public class KthSmallestElement {
    //Timecomplexity=O(NlogN)
    //Space complexity=O(1)
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
    public static int selectionProcedure(int[] arr,int l, int h,int k){
        if(l<h){
            //find the element using partiotion algorithm from where we will devide the Array
            int m = partition(arr,l,h);
            if(m==k-1){
                return arr[m];
            }else if(m<k-1){
                return selectionProcedure(arr, m+1, h, k);
            }else{
                return selectionProcedure(arr, l, m, k);
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {50,30,70,90,10,34,89,91,13};
        int n = arr.length;
        int k=8;
        System.out.println("The "+k+"th smallest element is:"+selectionProcedure(arr, 0, n-1, k));
    }
}
