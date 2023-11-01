package DSA_programs.IntroToHeaps;
import  java.util.*;
public class kthLargestSubArraySum {
    // public static int kthLargest(int N, int K, int[] Arr) {
    //     ArrayList<Integer> ar=new ArrayList<>();
    //     //store the subArray Sums in list
    //     for(int i=0;i<N;i++){
    //         int sum=0;
    //         for(int j=i;j<N;j++){
    //             sum+=Arr[j];
    //             ar.add(sum);
    //         }
    //     }
    //     Collections.sort(ar);
    //     System.out.println(ar);
    //     return ar.get(ar.size()-K);
    // }
    public static int kthLargest(int N, int K, int[] Arr) {
        Queue<Integer> minHeap=new PriorityQueue<>();
        for(int i=0;i<N;i++){
            int sum=0;
            for(int j=i;j<N;j++){
                sum+=Arr[j];
                if(minHeap.size()<K){
                    minHeap.add(sum);
                }else{
                    if(minHeap.peek()<sum){
                        minHeap.remove();
                        minHeap.add(sum);
                    }
                }
            }
        }
        return minHeap.peek();
    }
    public static void main(String[] args) {
        int[]  arr={1,2,3,4,5};
        System.out.println(kthLargest(arr.length,3,arr));
    }
}
