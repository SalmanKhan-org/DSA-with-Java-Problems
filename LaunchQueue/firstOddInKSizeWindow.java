package DSA_programs.LaunchQueue;

import java.util.Deque;
import java.util.LinkedList;

public class firstOddInKSizeWindow {
    //time complexity=O(n)
    //space complexity = O(n) for extra space of deque
    private static void firstOddEleInKSizeWindow(int[] arr,int k, int N){
        Deque<Integer> dq = new LinkedList<>();
        for(int i=0;i<k;i++){
            if(arr[i]%2==1){
                dq.addLast(i);
            }
        }
        for(int i=k;i<N;i++){
            if(!dq.isEmpty()){
            System.out.print(arr[dq.peek()]+" ");
            }else{
                System.out.print("0 ");
            }

            while(!dq.isEmpty()&&dq.peek()<=i-k){
                dq.removeFirst();
            }
            if(arr[i]%2==1){
                dq.addLast(i);
            }
        }
        if(!dq.isEmpty()){
        System.out.print(arr[dq.peek()]);
        }else{
            System.out.print("0 ");
        }
    }
    public static void main(String[] args) {
        int[] arr={2,2,2,2,2,2,2};
        int k=3;
        firstOddEleInKSizeWindow(arr, k, arr.length);
    }
}
