package DSA_programs.LaunchLinkedList;

public class InsertInLinkedList {
     static Node head;
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    //insert at the beginning of the list
    public void addFirst(int newData){
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }
    //Insert after any Node in linmked List
    public void addInMiddle(Node pre_Node, int data){
        if(pre_Node==null){
            System.out.println("the previous node cannot contain null  values:");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = pre_Node.next;
        pre_Node.next = newNode;
    }
    //insert at the end of the list
    public  void addLast(int newData){
        Node newNode = new Node(newData);
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
    public void printList(){
        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data+" ");
            currNode = currNode.next;
        }
    }
    //deletion at any node of the list
    public void remove(int pos){
        if(head == null){
            return;
        }
        Node temp = head;
        if(pos == 0){
            temp = temp.next;
            return;
        }
        for(int i=0;temp != null &&i<pos-1;i++){
            temp  = temp.next;
        }
        if(temp == null && temp.next==null){
            return;
        }
        temp.next = temp.next.next;
        return;
    }
    //Reversal of the list
    // public void reverseList(){
    //     Node curr = head;
    //     Node next = null;
    //     Node prev = null;
    //     while(curr != null){
    //         next = curr.next;
    //         curr.next = prev;
    //         prev =curr;
    //         curr = next;
    //     }
    //     head = prev;
    // }
    public void reverseList(Node cur,Node pre){
        if(cur.next == null){
            head = cur;
            cur.next = pre;
            return;
        }
        Node nextPtr = cur.next;
        cur.next = pre;
        reverseList( nextPtr, cur);
    }
    //middle element of the linked list 
    public void count(){
        Node temp = head;
        int count=0;
        while(temp.next != null){
            temp = temp.next;
            count++;
        }
        temp = head;
        if(temp == null && temp.next == null){
            return;
        }
        for(int i=0;i<count-2;i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
    //     System.out.println("The middle element of the lilst is:"+temp.data);

    }
     void middle(){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("The middle element is:"+slow.data);
    }
    //delete middle element
    // void deleteMiddle(){
    //     Node prev = null;
    //     Node slow = head;
    //     Node fast = head;
    //     while(fast != null && fast.next!=null){
    //         prev = slow;
    //         slow = slow.next;
    //         fast = fast.next.next;
    //     }
    //     prev.next = slow.next;
    // }
    // void detectLoop(){
    //     Node slow = head, Fast = head;
    //     boolean flag = false;
    //     while(slow != null && Fast != null && Fast.next != null) {
    //         slow = slow.next;
    //         Fast = Fast.next.next;
    //         if(slow == Fast){
    //             flag = true;
    //             break;
    //         }
    //     }
    //     if(flag){
    //         System.out.println("Loop detected in the list");
    //     }else{
    //         System.out.println("No Loop detected in the list");
    //     }
    // }
    public static void main(String[] args) {
        InsertInLinkedList list = new InsertInLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        System.out.println("Orignal List before insert at the end:");
        list.printList();
        System.out.println();
        System.out.println("The List after insert 5 At the End of the List:");
        list.addLast(5);
        list.printList();
        System.out.println();
        System.out.println("The list after append the 0 at the starting point:");
        list.addFirst(0);
        list.addFirst(-1);
        list.addFirst(-2);
        //list.printList();
        list.addInMiddle(list.head.next.next.next.next, 6);
        list.addInMiddle(list.head.next.next.next.next.next, 7);
        list.printList();
        System.out.println();
        list.remove(5);
        list.remove(5);
        list.printList();
        System.out.println();
        list.reverseList(head,null);
        list.printList();
        list.middle();
        list.count();
        list.printList();
        //list.deleteMiddle();
        // list.printList();
        // Node temp = list.head;
        // while(temp.next != null){
        //     temp = temp.next;
        // }
        // temp.next = list.head;
        // list.detectLoop();

    }
}
