package DSA_programs.LaunchRecursion;

import java.util.HashMap;
import java.util.HashSet;

public class subString {
    public static HashSet<String> set = new HashSet<>();
    public static void subSequences(int i, String str,String newStr){
        if(i == str.length()){
            // if(set.contains(newStr)){
            // return;
            // }else{
            //     System.out.println(newStr);
            //     set.add(newStr);
            //     return;
            // }
            System.out.println(newStr);
            return;
        }
        //to be
        char curChar = str.charAt(i);
        subSequences(i+1, str,newStr+curChar);
        //not to be
        subSequences(i+1, str, newStr);
    }
    public static void main(String[] args) {
        String str = "abc";
        //HashSet<String> set = new HashSet<>();
        subSequences(0,str,"");
    }
}
  