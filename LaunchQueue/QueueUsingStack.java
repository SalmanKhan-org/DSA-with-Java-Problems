package DSA_programs.LaunchQueue;

import java.util.Stack;

public class QueueUsingStack {
    static class Queue{
        Stack<Integer> s= new Stack<>();
        Stack<Integer> s1= new Stack<>();
        public boolean isEmpty(){
            return s.empty()&&s1.empty();
        } 
        //method for adding values in the queue
        public void add(int data){
            s.add(data);
        }
        //method for removing element from the queue
        public int remove(){
            if(isEmpty()) return -1;
            if(s1.isEmpty()){
               while(!s.isEmpty()){
                int top =  s.pop();
                s1.push(top);
               }
            }
            return s1.pop();
        }
        //method for displaying peek element
        public int peek(){
            return s1.peek();
        }
        public void display(){
            if(isEmpty()) return;
            while(!s.isEmpty()){
                System.out.println(s.pop());
            }
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(5);
        q.add(4);
        q.add(3);
        q.display();
        q.add(6);
        q.add(5);
        q.add(4);
        q.add(3);
        System.out.println("The deleted element is:"+q.remove());
        System.out.println("the  deleted element is:"+q.remove());
        
    }
}
