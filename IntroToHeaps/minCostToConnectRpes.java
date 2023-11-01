package DSA_programs.IntroToHeaps;
import java.util.*;
public class minCostToConnectRpes {
    static long minCost(long arr[], int n) 
    {
        Queue<Long> pq=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.add(arr[i]);
        }
        long ans=0;
        System.out.println("The  element of pq is:"+pq);
        while(pq.size()>1){
            long a=pq.remove();
            long b=pq.remove();
            long sum=a+b;
            ans+=sum;
            pq.add(sum);
        }
        return ans;
    }
    public static void main(String[] args) {
        long[] a={4,3,2,6};
        System.out.println("The minimum cost is:"+minCost(a, a.length));
    }
}
