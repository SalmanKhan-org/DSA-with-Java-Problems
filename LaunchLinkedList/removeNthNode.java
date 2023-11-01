package DSA_programs.LaunchLinkedList;

public class removeNthNode {
    static Node  head;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
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
    static void printList()
    public static void main(String[] args) {
        
    }
}

