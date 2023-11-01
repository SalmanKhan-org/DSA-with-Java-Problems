package DSA_programs.IntroToHeaps;

public class InsertionInHeap {
    static class Heap{
        int arr[];  
        int size;
        Heap(){
            arr=new int[4];
            //arr[0]= -1;
            size=0;
        }  
        //Time complexity=O(logn) for one element and for n element  will be  O(nlogn);
        //space complexity=O(1)
        public void insert(int val){
            int index=size;
            if(size>=arr.length){
                System.out.println("There is no space left for insert a new element:");
                return;
            }
            //1.insert the value at the last  position in the Array
            arr[index]=val;
            size++;
            //2.compare with  parent if smaller than parent then swap it with parent untill it is reach at its correct position
            while(index>0){
                //find  the parent element
                int parent=(index-1)/2;
                if(arr[parent]>arr[index]){
                    int temp=arr[parent];
                    arr[parent] = arr[index];
                    arr[index]  =temp;
                    index=parent;
                }else{
                    return;
                }
            }
        }
        private void display(){
            for(int i=0;i<size;i++){
                System.out.print(arr[i]+" ");
            }
        }
    }
    public static void main(String[] args) {
        Heap h=new Heap();
        h.insert(20);
        h.insert(30);
        h.insert(25);
        // h.insert(45);
        // h.insert(35);
        // h.insert(35);
        // h.insert(35);
        h.display();
    }
}