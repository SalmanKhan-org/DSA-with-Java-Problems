package DSA_programs.IntroToHeaps;



public class HeapifyAlgo {
    private static  void heapify(int[] arr,int size,int i){
        int largest=i;
        int leftchild=2*i;
        int rightchild=2*i+1;
        if(leftchild<=size&&arr[largest]<arr[leftchild]){
            largest=leftchild;
        }
        if(rightchild<=size&&arr[largest]<arr[rightchild]){
            largest=rightchild;
        }
        if(largest!=i){
            int temp=arr[i];
            arr[i]=arr[largest];
            arr[largest]=temp;
            heapify(arr, size, largest);
        }
    }
    private static void heapSort(int[] arr,int  n){
        int size=n;
        while(size>1){
            int temp=arr[1];
            arr[1]= arr[size];
            arr[size]= temp;
            size--;

            heapify(arr, size, 1);
        }
    }
    public static void display(int[] arr,int size){
        for(int i=1;i<size;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        int[] arr={-1,55,54,53,50,52};
        int n=5;
        for(int i=n/2;i>0;i--){
            heapify(arr, arr.length, i);
        }
        System.out.println("The elements of the heap before the sorting:");
        display(arr,arr.length);
        System.out.println("The elements of the heap after sorting:");
        heapSort(arr, n);
        display(arr, arr.length);
    }
}
