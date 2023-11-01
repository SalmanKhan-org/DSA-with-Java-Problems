package DSA_programs.LaunchStack;

import java.util.Scanner;
import java.util.Stack;

public class validParenthesis {
    public static boolean isValid(String s) {
        char[] carr = s.toCharArray();
        Stack<Character> st = new Stack<>();
        for(char ch:carr){
            if(ch=='('||ch=='['||ch=='{'){
                st.push(ch);
                //continue;
            }else{
            if(st.isEmpty())  return false;
            char top = st.pop();
            if(top=='('&&ch!=')'||top=='['&&ch!=']'||top=='{'&&ch!='}') return false;
            // if(top=='['&&ch!=']') return false;
            // if(top=='{'&&ch!='}') return false;
        }
    }
        return(st.isEmpty());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String:");
        String str=sc.next();
        System.out.println(isValid(str));
    }
}
