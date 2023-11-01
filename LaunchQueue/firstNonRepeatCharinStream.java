package DSA_programs.LaunchQueue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class firstNonRepeatCharinStream {
    private  static String FirstNonRepeating(String s){
        String ans = "";//for storing the  answer String
        HashMap<Character,Integer> hm = new HashMap<>();//for tracking the count of the character
        Queue<Character> q = new LinkedList<>();//for storing the non repeating char
        for(int i=0;i<s.length();i++){
            //add current char in hashmap if not present if present already update the count by one
            if(!hm.containsKey(s.charAt(i))){
                q.add(s.charAt(i));
            }
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0)+1);
            while(!q.isEmpty()&&hm.get(q.peek())>1){
                q.remove();
            }
            if(!q.isEmpty()){
                ans+=q.peek();
            }else{
                ans+='#';
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        System.out.println(FirstNonRepeating(str));
    }
}
