package DSA_programs.LaunchLinkedList;

public class searchInLinkedList {
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
    static boolean isContain(int x){
        Node temp = head;
        if(x == temp.data){
            return true;
        }
        while(temp.next != null){
            if(temp.data == x){
                return true;
            }
            temp = temp.next;
        }
        if(temp.data == x){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        //searchInLinkedList list = new searchInLinkedList();
        push(10);
        push(30);
        push(11);
        push(21);
        push(14);
        displayList();
        System.out.println(isContain(30));
        
    }
}
