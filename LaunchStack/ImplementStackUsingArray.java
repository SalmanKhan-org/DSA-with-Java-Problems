package DSA_programs.LaunchStack;

public class ImplementStackUsingArray {
    static class Stack{
        int arr[];
        int size;
        int top;
        Stack(int size){
            this.size = size;
            this.arr=new int[size];
            top=-1;
        }
        private boolean empty(){
            if(top==-1) return true;

            return false;
        }
        private void push(int x){
            if(top==arr.length){
                System.out.println("Stack overflow");
                return;
            }
            //top=top+1;
            arr[++top]=x;
        }
        private int pop(){
            if(top==-1){
                return -1;
            }
            int ele=arr[top];
            top--;
            return ele;
        }
        private int peek(){
            if(top==-1){
                return -1;
            }
            return arr[top];
        }
    }
    public static void main(String[] args) {
        Stack s =new Stack(4);
        s.push(2);
        s.push(4);
        s.push(5);
        s.push(7);
        System.out.println("The peek element of the Stack is:"+s.pop());
        while(!s.empty()){
            System.out.print(s.pop()+" ");
        }
    }
}
