package DSA_programs.LaunchLinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class palindromeLinkedList {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static void addLast(int newData){
        Node newNode =new Node(newData);
        if(head == null){
            head = newNode;
            return;
        }
        Node curNode = head;
        while(curNode.next != null){
            curNode = curNode.next;
        }
        curNode.next = newNode;
        return;
    }
    static void printList(){
        Node curNode = head;
        while(curNode != null){
            System.out.print(curNode.data+" ");
            curNode = curNode.next;
        }
    }
    static boolean palindrome(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node temp1 = head;
        Node temp2 = slow.next;

        Node curr = temp2;
        Node next = null;
        Node prev = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev =curr;
            curr = next;
        }
        temp2 = prev;



        while(temp2 != null ){ 
            if(temp1.data != temp2.data){
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;
}

    public static void main(String[] args) {
        addLast(1);
        addLast(2);
       // addLast(2);
        //addLast(1);
        //addLast(2);
        printList();
        System.out.println(palindrome(head));
        HashMap<Integer,Integer> map =new HashMap<>();
        map.get
    }
}
