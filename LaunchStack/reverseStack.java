package DSA_programs.LaunchStack;

import java.util.*;


public class reverseStack {
    //Approach-1 using recursion
    //time complexity=O(N^2);
    //space complexity=O(N) for recursive calls
    public static void insertAtBottom(Stack<Integer> s,int ele){
        //base case
        if(s.empty()){
            s.add(ele);
            return;
        }
        int top =s.pop();
        insertAtBottom(s, ele);
        s.add(top);
    }
    public static void reverse(Stack<Integer> stack){
        //base case
        // if(stack.empty()){
        //     return;
        // }
        // int top = stack.pop();
        // reverse(stack);
        // //Now insert the each element at the bottom
        // insertAtBottom(stack,top);


        //Approach-2 using Queue Data Structure
        //time complexity = O(N)
        //space complexity=O(N) for queue data structure
        Queue<Integer> q = new LinkedList<>();
        while(!stack.empty()){
            q.add(stack.pop());
        }
        while(!q.isEmpty()){
            stack.push(q.remove());
        }
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.add(9);
        s.add(3);
        s.add(2);
        s.add(1);
        System.out.println("The element of the Stack before reversing:"+s);
        System.out.println("The element of the Stack after reversing:");
        reverse(s);
        System.out.println(s);
    }
}
