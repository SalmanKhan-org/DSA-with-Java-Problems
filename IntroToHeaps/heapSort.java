package DSA_programs.IntroToHeaps;

public class heapSort {
     //Function to build a Heap from array.
     static void  buildHeap(int arr[], int n)
     {
         for(int i=(n/2)-1;i>=0;i--){
             heapify(arr,n,i);
         }
     }
  
     //Heapify function to maintain heap property.
     static void  heapify(int arr[], int n, int i)
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
     
     //Function to sort an array using Heap Sort.
     public  static void  heapSort(int arr[], int n)
     {
         int size=n-1;
         while(size>0){
             int temp=arr[0];
             arr[0]= arr[size];
             arr[size]= temp;
             size--;
             heapify(arr,size,0);
         }
     }
    public static void main(String[] args) {
       int[] arr={5,8,9,4,2,1};
       buildHeap(arr, arr.length);
       heapSort(arr, arr.length);
       System.out.println("The elements after sorting:");
       for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
       }
    }
}
