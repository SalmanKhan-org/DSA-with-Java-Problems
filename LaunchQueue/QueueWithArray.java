package DSA_programs.LaunchQueue;
//Implementation of   Queue  using Arrays
public class QueueWithArray {
    static class Queue{
        static int[] arr;
        static int size;
        static int rear=-1,front=-1;
        Queue(int size){
            this.size = size;
            arr = new int[size];
        }
        public boolean isEmpty(){
            return rear == -1;
        }
        //method for addingthe values int the queue
        public void add(int data){
            //if the queue will full
            if(rear==size-1) return;
            //if the queue don't have any element
            if(isEmpty()){
                front+=1;
                rear+=1;
                arr[rear] = data;
            }else{//queue already have data
                rear+=1;
                arr[rear] = data;
            }
        }
        //method for removing the element
        public int remove(){
            //if the queue is empty
            int x=0;
            if(isEmpty()) return -1;
            else {
                x = arr[front];
                if(front==rear){
                    front=rear=-1;
                }else{
                    front++;
                }
            }
            return x;
        }
        //method for peek element
        public int peek(){
            if(isEmpty()) return -1;
            else{
                return arr[front];
            }
        }
        public void display(){
            if(isEmpty()) return;
            for(int i=front;i<=rear;i++){
                System.out.println(arr[i]);
            }
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue(3);
        q.add(1);
        q.add(2);
        q.add(3);
        int x=q.remove();
        System.out.println("The peek element is:"+q.peek());
        q.display();
    }
}
