package DSA_programs.LaunchStack;

import java.util.Scanner;
import java.util.Stack;

public class redundantBrackets {
    public static boolean findRedundantBrackets(String s) {
        Stack<Character> st =  new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='('||ch=='+'||ch=='/'||ch=='*'||ch=='-'){
                st.push(ch);
                continue;
            }else{
                if(ch==')'){
                    boolean isRedundant=true;
                    while(st.peek()!='('){
                        int top =st.pop();
                        if(top=='+'||top=='/'||top=='*'||top=='-'){
                            isRedundant=false;
                        }
                    }
                    st.pop();
                    if(isRedundant==true){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String:");
        String str =sc.next();
       System.out.println(findRedundantBrackets(str));
    }
}
