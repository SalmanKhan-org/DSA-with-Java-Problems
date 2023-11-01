package DSA_programs.LaunchLinkedList;

public class reverseList {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public  static void addLast(int newData){
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
    public static void printList(){
        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data+" ");
            currNode = currNode.next;
        }
    }
    static void reverse(int left, int right){
        if(left == right) return;
        Node bLeft =null,leftNode=head,temp = null;
        while(left != 1){
            bLeft = leftNode;
            leftNode = leftNode.next;
            left--;
        }
       // bLeft.next = null;
        temp = leftNode;
        Node rightNode = temp;
        //System.out.println(curNode2.data);
        while(right  != right-left ){
            rightNode = rightNode.next;
            right--;
        }
        System.out.println(rightNode.data);
        Node aRight = rightNode.next;
        //System.out.println(curNode2.data);
        //bLeft.next = null;
        Node next = null,prev = null;
        while(leftNode != rightNode.next){
            next = leftNode.next; 
            leftNode.next = prev;
            prev = leftNode;
            leftNode = next;
        }
        bLeft.next = null;
        temp.next = aRight;
        bLeft.next = prev;
    }
    public static void main(String[] args) {
        addLast(1);
        addLast(2);
        addLast(3);
        addLast(4);
        addLast(5);
        reverse(2, 4);
        printList();

    }
}
