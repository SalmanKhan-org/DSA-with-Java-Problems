package DSA_programs.LaunchQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueReversal {
    //Approach-1 using Stack 
    //Approach-2 using deque
    //Approach-3 using recursion most efficient approach
    public static void reverseQueue(Queue<Integer>  q){
        // Stack<Integer> s=new Stack<>();
        // if(q.isEmpty()) return;
        // while(!q.isEmpty()){
        //     s.push(q.remove());
        // }
        // while(!s.isEmpty()){
        //     System.out.print(s.peek()+" ");
        //     s.pop();
        // }

        if(q.isEmpty()) return;
        int ele = q.remove();
        reverseQueue(q);
        System.out.print(ele+" ");
    }
    public static void main(String[] args) {
        Queue<Integer>  q=new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println("Before Reversal the Queue is looks like:");
        System.out.println(q);
        System.out.println("After reversal Queue is looks like:");
        reverseQueue(q);
    }
}
