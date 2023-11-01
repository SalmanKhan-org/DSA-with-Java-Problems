package DSA_programs.LaunchStack;

import java.util.Stack;

public class pushAtBottom {
    public static void pushAtbottom(int data, Stack<Integer> s){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtbottom(data, s);
        s.push(top);
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        //stack.push(4);
        pushAtbottom(4, stack);
        while(!stack.isEmpty()){
            System.out.println(stack.peek());
            stack.pop();
    }
}
}
