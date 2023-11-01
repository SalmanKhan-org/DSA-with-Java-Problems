package DSA_programs.LaunchQueue;

public class kQueueUsingSingleArray {
    static class Queue{
        int size;
        int k;
        int[] front;
        int[] rear;
        int[] arr;
        int[] next;
        int freeSlot;
        public Queue(int size,int k){
            this.size = size;
            this.k= k;
            front = new  int[k];
            rear = new int[k];
            //initialize front and rear with -1
            for(int i=0;i<k;i++){
                front[i]= -1;
                rear[i]= -1;
            }
            next = new int[size];
            //intialize next with next empty slot
            for(int i=0;i<size;i++){
                next[i] = i+1;
            }
            next[size-1]=-1;
            arr =new int[size];
            freeSlot=0;
        }
        //code for push method
        private  void push(int x, int qn){
            int index = freeSlot;
            freeSlot = next[index];

            if(freeSlot == -1){
                System.out.println("No empty slot");
                return;
            }
            if(front[qn-1]==-1){
                front[qn-1] = index;
                //next[index] = -1;
            }else{
                next[rear[qn-1]] = index;
            }
            next[index] = -1;
            rear[qn-1] = index;
            arr[index] = x;
        }
        private int pop(int qn){
            if(front[qn-1]==-1){
                return -1;
            }
            int index = front[qn-1];
            front[qn-1] = next[index];

            next[index] = freeSlot;
            freeSlot= index;
            return arr[index];
        }
    }
    public static void main(String[] args) {
        Queue q =new Queue(6, 2);
        q.push(1, 1);
        q.push(2, 1);
        q.push(3, 2);
        q.push(4, 2);
        q.push(5,1);
        System.out.println(q.pop(2));
        System.out.println(q.pop(2));
        System.out.println(q.pop(1));
        System.out.println(q.pop(1));
        System.out.println(q.pop(1));
    }
}
