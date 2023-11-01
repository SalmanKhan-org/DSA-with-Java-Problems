package DSA_programs.LaunchQueue;

public class QueueUsingLinkedLlist {
    static Node head;
    static class Node{
        int  val;
        Node next;
        Node(int val){
            this.val = val;
            next=null;
        }
    }
    static class Queue{
        //Node front=null;
        Node rear=null;
        //method for adding the element into the queue
        //time complexity of add function is O(1)
        public void add(int data){
            Node newNode = new Node(data);
            //Queue is empty
            if(rear==null){
                head = newNode;
                //front = head;
                rear = head;
            }else{
                rear.next = newNode;
                rear = rear.next;
            }
        }
        //method for removing  the value
        //time complexity of remove function is O(1)
        public int remove(){
            int  val=0;
            //if the queue is empty
            if(rear == null) return -1;  
            else{
                val = head.val;
                head = head.next;
                //front= head;
            }
            return val;
        }
        //method for peek element
        //time complexity of peek function is O(1)
        public int peek(){
            if(rear == null) return -1;
            else{
                return head.val;
            }
        }
        //method for displaying the queue
        public void display(){
            while(head!=null){
                System.out.println(head.val);
                head = head.next;
            }
        }
    }
    public static void main(String[] args) {
        Queue q  = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println("The removing element is:"+q.remove());
        q.display();
    }
}
