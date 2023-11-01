package DSA_programs.LaunchLinkedList;

import java.util.ArrayList;
import java.util.List;

public class swapNodes {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static void push(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    static void displayList(){
        Node cur_Node = head;
        while(cur_Node != null){
            System.out.print(cur_Node.data+" ");
            cur_Node = cur_Node.next;
        }
    }
    public static void swap(int k){
        Node temp = head;
        List<Node> arr = new ArrayList<>();
        while(temp != null){
            arr.add(temp);
            temp = temp.next;
        }
        int l = 0;
        int r = arr.size();
        int temp1 = arr.get(k-1).data;
        arr.get(k-1).data = arr.get(r-1).data;
        arr.get(r-1).data = temp1;
        
    }
    public static void main(String[] args) {
        
        push(2);
        push(1);
        displayList();
        swap(1);
        System.out.println();
        displayList();
    }
}
