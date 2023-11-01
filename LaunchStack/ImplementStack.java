package DSA_programs.LaunchStack;

import java.util.ArrayList;

public class ImplementStack {
    //Using LinkedList
    // static Node  head;
    // static class Node{
    //     int data;
    //     Node next;

    //     public Node(int data){
    //         this.data = data;
    //         this.next = null;
    //     }
    // }
    // public static class Stack{
    //     //push method for adding value in the stack
    //     public  void push(int data){
    //         Node newNode = new Node(data);//creating a node of new data
    //         if(head == null){
    //             head = newNode;
    //             return;
    //         }
    //         newNode.next= head;
    //         head = newNode;
    //     }
    //     //pop method for fetching the peek value and it will delete the peek element
    //     public  int pop(){
    //         if(head ==null){
    //             return -1;
    //         }
    //         int data = head.data;
    //         head =head.next;
    //         return data;
    //     }
    //     //peek  method for fetching the topmost element but it wiil not delete the topmost element;
    //     public  int peek(){
    //         if(head == null){
    //             return -1;
    //         }
    //         return head.data;
    //     }
    // }
    // public static void main(String[] args) {
    //     Stack stack = new Stack();
    //     stack.push(1);
    //     stack.push(2);
    //     stack.push(3);
    //     stack.push(4);
    //     System.out.println("The topmost element of the Stack is :"+stack.peek());
    //     System.out.println(stack.pop());
    //     while(head  !=  null){
    //         System.out.println(stack.peek());
    //         //head= head.next;
    //         stack.pop();
    //     }
    // }




    //Using Arraylist
    static class Stack{
       ArrayList<Integer> list =new ArrayList<>();
    public   void push(int data){
        list.add(data);
        return;
    }
    public  int pop(){
        int top = list.get(list.size()-1);
        list.remove(list.size()-1);
        return top;
    }
    public  int peek(){
        return list.get(list.size()-1);
    }
}
    public static void main(String[] args) {
    Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        while(stack.list.size()!=0){
            System.out.println(stack.peek());
            stack.pop();
        }
   }
}
