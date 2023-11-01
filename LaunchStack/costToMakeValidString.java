package DSA_programs.LaunchStack;

import java.util.Scanner;
import java.util.Stack;

public class costToMakeValidString {
    public   static int findMinimumCost(String str) {
        Stack<Character> s =new Stack<>();
        //if the length of the  String is odd then it is impossible to make String valid return -1;
        if(str.length()%2==1) return -1;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='{'){
                s.push(str.charAt(i));
            }else{
                if(!s.empty()&&s.peek()=='{'){
                    s.pop();
                }else{
                    s.push(str.charAt(i));
                }
            }
        }
        int a=0,b=0;//a will store the open brackets and b will store the closed brackets
        while(!s.empty())
        {
            char top = s.pop();
            if(top == '{') {
                a++;
            }
            else{
                b++;
            }
        }
        int ans = (a+1)/2+(b+1)/2;
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter the String:");
        String str =sc.next();
        if(findMinimumCost(str)==-1){
            System.out.println("It is not possible to make the String a valid String:");
        }else{
            System.out.println("The minimum cost to make the String a valid String is:"+findMinimumCost(str));
        }
    }
}
