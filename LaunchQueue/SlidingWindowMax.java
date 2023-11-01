package DSA_programs.LaunchQueue;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMax {
    private  static void maxEleInWindow(int[] arr, int N,int k){
        Deque<Integer> q = new LinkedList<>();
        //1-> process first k element
        int i;
        for(i=0;i<k;i++){
            while(!q.isEmpty()&&arr[i]>=arr[q.peekLast()]){
                q.removeLast();
            }
            q.addLast(i);
        }
        //process rest of the  element
        for(;i<N;i++){
            System.out.print(arr[q.peek()]+" ");

            while(!q.isEmpty()&&q.peek()<=i-k){
                q.removeFirst();
            }

            while(!q.isEmpty()&&arr[i]>=arr[q.peekLast()]){
                q.removeLast();
            }
            q.addLast(i);
        }
        System.out.print(arr[q.peek()]);
    }                                                                                                                                                        
    public static void main(String[] args) {
        int arr[] = {1,3,-1,-3,5,3,6,7};
        int k =3;
        maxEleInWindow(arr, arr.length, k);
    }
}   