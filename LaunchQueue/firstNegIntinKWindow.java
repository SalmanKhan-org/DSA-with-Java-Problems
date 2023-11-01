package DSA_programs.LaunchQueue;

import java.util.Deque;
import java.util.LinkedList;

public class firstNegIntinKWindow {
    private static void firstNegativeInteger(int[] arr,int N, int k){
        Deque<Integer> q = new LinkedList<>();
        int i;
        for(i=0;i<k;i++){
            if(arr[i]<0){
                q.addLast(i);
            }
        }
        for(i=k;i<N;i++){
            if(!q.isEmpty()){
                System.out.print(arr[q.peek()]+" ");
            }else{
                System.out.print("0 ");
            }
            while(!q.isEmpty()&&q.peekFirst()<=i-k){
                q.removeFirst();
            }
            if(arr[i]<0){
                q.addLast(i);
            }
        }
        System.out.print(arr[q.peekFirst()]);
    }
    public static void main(String[] args) {
        int arr[] ={-8,2,3,-6,10};
        int k =2;
        firstNegativeInteger(arr, arr.length, k);
    }
}
