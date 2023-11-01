package DSA_programs.LaunchStack;

import java.util.Stack;

public class reverseString {
    public static void main(String[] args) {
        String str = "abcde";
        Stack<Character> s = new Stack<>();
        for(int i=0;i<str.length();i++){
             char ch=str.charAt(i);
             s.add(ch);
        }
        //System.out.println(s);
        while(!s.empty()){
            char ch =  s.pop();
            System.out.print(ch);
        }
    }
}
