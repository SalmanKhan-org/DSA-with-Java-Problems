package DSA_programs.LaunchStack;

import java.util.Stack;

public class deleteMiddleEle {
    public static void solve(Stack<Integer> s,int count, int size){
        //base case
        if(count==size/2){
            s.pop();
            return;
        }
        int top = s.pop();
        solve(s,count+1,size);
        s.add(top);
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.add(4);
        s.add(2);
        s.add(9);
        s.add(5);
        solve(s,0,s.size());
        while(!s.empty()){
            System.out.print(s.pop());
        }
    }
}
