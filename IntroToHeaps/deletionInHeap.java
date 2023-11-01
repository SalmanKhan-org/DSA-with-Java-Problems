package DSA_programs.IntroToHeaps;

import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;

public class deletionInHeap {
    static class Heap{
        int arr[];  
        int size;
        Heap(){
            arr=new int[50];
            arr[0]= -1;
            size=0;
        }  
        public void insert(int val){
            size=size+1;
            int index=size;
            arr[index]=val;
            while(index>1){
                int parent=index/2;
                if(arr[parent]<arr[index]){
                    int temp=arr[parent];
                    arr[parent] =arr[index];
                    arr[index]=temp;
                    index=parent;  
                }else{
                    return;
                }
            }
        }    
        public void display(){
            for(int i=1;i<=size;i++){
                System.out.print(arr[i]+" ");
            }
        }
        public void delete(){
            if(size==0){
                System.out.println("There  is no element to delete:");
                return;
            }
            //1.replace topmost element with last element 
            arr[1]=arr[size];
            //2.decrease the size so that last would be delete
            size--;
            //3.adjust the topmost element at its  current position
            int i=1;
            while(i<size){
                int leftchild=2*i;
                int rightchild=2*i+1;
                //if leftchild element is greter than  the root element then swap root element with leftchild
                if(leftchild<size&&arr[leftchild]>arr[i]){
                    int temp=arr[i];
                    arr[i]=arr[leftchild];
                    arr[leftchild] = temp;
                    i=leftchild;
                }else  if(rightchild<size&&arr[rightchild]>arr[i]){ //if rightchild element is greter than  the root element then swap root element with rightchild
                    int temp=arr[i];
                    arr[i]=arr[rightchild];
                    arr[rightchild] = temp;
                    i=rightchild;
                }else{
                    return;
                }
            }
        }
    }
    public static void main(String[] args) {
        Heap h=new Heap();
        h.insert(45);
        h.insert(21);
        h.insert(30);
        h.insert(44);
        h.insert(25);
        // h.display();
        // System.out.println("\nAfter deletion:");
        // h.delete();
        // h.delete();
        // h.delete();
        h.display();
    }
}
