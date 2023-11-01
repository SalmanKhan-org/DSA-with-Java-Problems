package DSA_programs.IntroToHeaps;

import java.util.Currency;

import javax.swing.plaf.ColorUIResource;

public class ImplementMinHeap {
    static class MinHeap {

        int[] minHeapArr;
        int maxCapacity;
        int currCapacity;
        MinHeap(int size) {
            this.maxCapacity=size;
            minHeapArr=new int[size];
            currCapacity=0;
        }

        // Implement the function to remove minimum element.
        int extractMinElement() {
            if(currCapacity<=0){
                return -1;
            }
            int minEle=minHeapArr[0];
            delete(0);
            return minEle;
        }

        // Implement the function to delete an element.
        public void delete(int ind){
            if(currCapacity<ind){
                System.out.println("There  is no element to delete:");
                return;
            }
            //1.replace topmost element with last element 
            minHeapArr[ind]=minHeapArr[currCapacity-1];
            //2.decrease the size so that last would be delete
            currCapacity--;
            //3.adjust the topmost element at its  current position
            heapify(minHeapArr, currCapacity, ind);
            }
        public  void  heapify(int[] arr,int size,int i){
            int smallest=i;
            int leftchild=2*i+1;
            int rightchild=2*i+2;
            if(leftchild<size&&minHeapArr[smallest]>minHeapArr[leftchild]){
                smallest=leftchild;
            }
            if(rightchild<size&&minHeapArr[smallest]>minHeapArr[rightchild]){
                smallest=rightchild;
            }
            if(smallest!=i){
                int temp=arr[i];
                minHeapArr[i]=minHeapArr[smallest];
                minHeapArr[smallest]=temp;
                heapify(arr, size, smallest);
            }
        }

        // Implement the function to insert 'val' in the heap.
        void insert(int val) {
            int index=currCapacity;
            currCapacity++;
            minHeapArr[index]=val;
            while(index>0){
                int parent=(index-1)/2;
                if(minHeapArr[parent]>minHeapArr[index]){
                    int temp=minHeapArr[parent];
                    minHeapArr[parent]=minHeapArr[index];
                    minHeapArr[index]=temp;
                    index=parent;
                }else{
                    return;
                }
            }
        }
        void display(){
            for(int i=0;i<currCapacity;i++){
                System.out.print(minHeapArr[i]+"  ");
            }
        }
    }
    public static void main(String[] args) {
        MinHeap h =new MinHeap(5);
        h.insert(5);
        h.insert(6);
        h.insert(2);
        h.insert(1);
        // int  min=h.extractMinElement();
        // System.out.println("The topmost element  is:"+min);
        h.display();
        System.out.println();
        h.delete(1);
        //System.out.println("The  topmost element is:"+h.extractMinElement());
        h.display();
        // System.out.println();
        // System.out.println("The  topmost element is:"+h.extractMinElement());
        // h.display();
    }
}
