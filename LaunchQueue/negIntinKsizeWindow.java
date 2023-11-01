package DSA_programs.LaunchQueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class negIntinKsizeWindow {
    public static long[] printFirstNegativeInteger(int[] A,int n,int k){
        Deque<Integer> dq = new LinkedList<>();
        long[] arr = new long[n-k+1];
        int j=0;
        for(int i=0;i<k;i++){
            if(A[i]<0){
                dq.addFirst(i);
            }
        }
        if(dq.size()>0){
            arr[j] = A[dq.getFirst()];
        }else{
            arr[j] = 0;
        }
        for(int i=k;i<n;i++){
            if(!dq.isEmpty()&&i-dq.getFirst()>=k){
                dq.removeFirst();
            }
            if(A[i]<0){
               
                dq.addFirst(i);
            }
            if(dq.size()>0){
                j++;
                arr[j] =A[dq.getFirst()];
            }else{
                j++;
                arr[j] = 0;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {-8,2,3,-6,10};
        long[] arr1=printFirstNegativeInteger(arr, arr.length, 2);
        System.out.println(Arrays.toString(arr1));
    }
}
