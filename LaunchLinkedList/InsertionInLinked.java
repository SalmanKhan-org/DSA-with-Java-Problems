package DSA_programs.LaunchLinkedList;

public class InsertionInLinked {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    //Insert element at the beginning of the linked list
    static void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
        return;
    }
    //Insert after at any Node
    static void addInMiddle(int pos,int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node curNode = head;
        for(int i=0;i<pos-1;i++){
            curNode = curNode.next;
        }
        if(curNode == null){
            System.out.println("current node cannot be equal to null");
        }else{
        newNode.next = curNode.next;
        curNode.next = newNode;
        }
        return; 
    }
    //Insert element at the end of the linked list
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
    //deletion of any node
    static void remove(int pos){
        if(head == null){
            return;
        }
        Node temp = head;
        if(pos == 0){
            head = head.next;
            return; 
        }
        for(int i=0;temp != null&&i<pos-1;i++){
            temp = temp.next;
        }
        if(temp == null || temp.next == null){
            return;
        }
        temp.next = temp.next.next;
        return;
    }
    static void printList(){
        Node curNode = head;
        while(curNode != null){
            System.out.print(curNode.data+" ");
            curNode = curNode.next;
        }
    }
    static void middle(){
        Node slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.data+" "+slow.next);
    }
    public static void main(String[] args) {
        addLast(14);
        addLast(36);
        addLast(9);
        addLast(69);
        addLast(46);
        addLast(22);
        addLast(35);
        addLast(50);
        addLast(40);
        addLast(50);
        addLast(40);
        addLast(35);
        addLast(36);
        // addFirst(0);
        // addFirst(-1);
        // addFirst(-2);
        // addFirst(-3);
        //addInMiddle(2, -2);
       // remove(5);
        printList();
        System.out.println();
        middle();
    }
}
