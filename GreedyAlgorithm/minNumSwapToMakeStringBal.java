package DSA_programs.GreedyAlgorithm;

import java.util.Stack;

public class minNumSwapToMakeStringBal {
    //Time complexity=O(n) where n is length of String
    //Space complexity=O(n) for Stack
    public static int minimumSwaps(String s){
        int swaps=0,stack=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='['){
                stack++;
            }else{
                if(stack!=0) stack--;
                else{
                    swaps++;
                }
            }
        }
        return (swaps+1)/2;
        // Stack<Character> st= new Stack<>();
        // int swaps=0;
        // for(int i=0;i<s.length();i++){
        //     if(s.charAt(i)=='['){
        //         st.push(s.charAt(i));
        //     }else{
        //         if(!st.empty()){
        //             st.pop();
        //         }else{
        //             swaps++;
        //         }
        //     }
        // }
        // return (swaps+1)/2;
    }
    public static void main(String[] args) {
        String str = "[]]][]";
        System.out.println("The minimum number of swaps required to make given string balanced is:"+minimumSwaps(str));
    }
}
