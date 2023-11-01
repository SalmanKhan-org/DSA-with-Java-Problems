package DSA_programs.LaunchQueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class reverseFirstKEle {
    public static Queue<Integer> reverseFirstKelements(Queue<Integer> q,int k){
        // Stack<Integer> s = new Stack<>();
        // //add the first k element into stack
        // for(int i=0;i<k;i++){
        //     s.push(q.remove());
        // }
        // //now again add the element of stack into queue
        // while(!s.empty()){
        //     q.add(s.pop());
        // }
        // //push back the first n-k element of queue
        // for(int i=0;i<q.size()-k;i++){
        //     q.add(q.remove());
        // }

        //approach-2 using deque
        //Time complexity = O(N)
        //Space complexity = O(N) For extra space of deque
        Deque<Integer> dq = new LinkedList<>();
        for(int i=0;i<k;i++){
            dq.addLast(q.remove());
        }
        while(!dq.isEmpty()){
            q.add(dq.removeLast());
        }
        for(int i=0;i<q.size()-k;i++){
            q.add(q.remove());
        }
        return q;
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.println(reverseFirstKelements(q, 3));
    }
}
