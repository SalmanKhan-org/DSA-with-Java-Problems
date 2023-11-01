package DSA_programs.LaunchStack;

import java.util.Stack;

public class sortStack {
    static void sort(Stack<Integer> s, int num){
        if(s.empty()||num<s.peek()){
            s.push(num);
            return;
        }
        int top = s.pop();
        sort(s, num);
        s.push(top);
    }
    public static void sortStacks(Stack<Integer> stack) {
		// Write your code here.
        if(stack.empty()) return;
        int num = stack.pop();
        sortStacks(stack);
        sort(stack,num);
	}
    public static void main(String[] args) {
        Stack<Integer> s =new Stack<>();
        s.push(-2);
        s.push(9);
        s.push(-7);
        s.push(3);
        s.push(5);
        s.push(-9);
        sortStacks(s);
        System.out.println(s);
    }
}
