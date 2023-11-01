package DSA_programs.LaunchStack;

public class NStackUsingSingleArray {
    static class Stack{
        int size;
        int k;
        int[] top;
        int[] next;
        int[] arr;
        int free=0;

        Stack(int size,int k){
            this.size=size;
            this.k=k;
            top = new int[k];
            for(int i=0;i<k;i++){
                top[i] = -1;
            }
            next = new int[size];
            for(int i=0;i<size-1;i++){
                next[i] = i+1;
            }
            next[size-1] = -1;
            arr = new int[size];
        }
        private void push(int ele,int sn){
            if(free == -1){
                System.out.println("Stack overflow");
                return;
            }
            int i=free;
            free = next[i];
            next[i] = top[sn-1];
            top[sn-1]=i;
            arr[i] = ele;
        }
        private int pop(int sn){
            if(top[sn-1]==-1){
                System.out.println("Stack underflow");
                return -1;
            }
            int i = top[sn-1];
            top[sn-1] = next[i];
            next[i] = free;
            free = i;
            return arr[i];
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack(5, 2);
        s.push(10, 1);
        s.push(12,1 );
        s.push(13, 2);
        s.push(14, 1);
        System.out.println(s.pop(1));
        System.out.println(s.pop(2));
        System.out.println(s.pop(1));
        System.out.println(s.pop(1));
    }
}
