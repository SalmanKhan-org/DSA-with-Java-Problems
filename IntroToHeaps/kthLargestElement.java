package DSA_programs.IntroToHeaps;
import java.util.*;
public class kthLargestElement {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int arr[] ={3,2,3,1,2,4,5,5,6};
        Queue<Integer> pq=new PriorityQueue<>();
        System.out.println("Enter the kth element::");
        int k=sc.nextInt();
        for(int i=0;i<k;i++){
            pq.add(arr[i]);
        }
        for(int i=k;i<arr.length;i++){
            if(pq.peek()<arr[i]){
                pq.remove();
                pq.add(arr[i]);
            }
        }
        System.out.println("The kth largest element in array  is:"+pq.peek());
    }
}
