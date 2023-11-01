package DSA_programs.LaunchQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InterleaveFirstHalfinSecondHalf {
    // private static ArrayList<Integer> interleavingQueue(Queue<Integer> q1,int N){
    //     ArrayList<Integer> al = new ArrayList<>();
    //     Queue<Integer> q2 = new LinkedList<>();
    //     //add first half of q1 into q2
    //     int i=0;
    //     while(i !=N/2){
    //         q2.add(q1.remove());
    //         i++;
    //     }
    //     for(int j=0;j<N/2;j++){
    //         al.add(q2.remove());
    //         al.add(q1.remove());
    //     }
    //     return al;
    // }
    //using stack
    // private static Queue<Integer> interleavingQueue(Queue<Integer> q1,int N){
    //     Stack<Integer> s = new Stack<>();
    //     for(int i=0;i<q1.size()/2;i++){
    //         s.add(q1.remove());
    //     }
    //     while(!s.empty()){
    //         q1.add(s.pop());
    //     }
    //     for(int i=0;i<q1.size()/2;i++){
    //         s.add(q1.remove());
    //     }
    //     for(int i=0;i<q1.size()/2;i++){
    //         q1.add(q1.remove());
    //     }
    //     while(!s.empty()){
    //         int val = s.pop();
    //         q1.add(val);
    //         q1.add(q1.remove());
    //     }
    //     return q1;

    //efficient approach without using stack and arralist
    //Time complexity = O(n);
    //Space complexity = O(n); 
    private static Queue<Integer> interleavingQueue(Queue<Integer> q1,int N){
        Queue<Integer> q2 = new LinkedList<>();
        //add first half element of q1 to  q2
        while(q1.size()!=N/2){
            q2.add(q1.remove());
        }
        //pick one element form q2 and add to q1 and one element from q1 and add to q1 untill q1 is q2 is not empty
        while(!q2.isEmpty()){
            int x = q2.remove();
            q1.add(x);
            q1.add(q1.remove());
        }
        return q1;
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        // ArrayList<Integer> al =  interleavingQueue(q, q.size());
        // System.out.println(al);
        Queue<Integer> q1=interleavingQueue(q, q.size());
        System.out.println(q1);
    }
}
