package DSA_programs.LaunchLinkedList;

public class removeDuplicates {
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
    static void removeDup(){
        Node cur_Node = head;
        if(cur_Node ==null || cur_Node.next==null){
            return;
        }
        while(cur_Node != null && cur_Node.next != null){
            if(cur_Node.data == cur_Node.next.data){
                //cur_Node = cur_Node.next;
                //continue;
            }else{
                cur_Node = cur_Node.next;
            }
        }
        return;
    }
    public static void main(String[] args) {
        removeDuplicates r = new removeDuplicates();
        push(3);
        push(3);
        push(2);
        push(2);
        push(2);
        push(2);
        push(2);
        push(1);
        displayList();
        removeDup();
        System.out.println();
        displayList();
    }
}
