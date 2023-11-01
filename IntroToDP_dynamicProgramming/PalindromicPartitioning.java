package DSA_programs.IntroToDP_dynamicProgramming;
import java.util.*;
public class PalindromicPartitioning {
    //static ArrayList<ArrayList<String>> result=new ArrayList<>();
    private  static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        ArrayList<ArrayList<String>> result=new ArrayList<>();
        partition(S, 0, new ArrayList<>(),result);

        return result;
    }
    private static  void partition(String s,int i,ArrayList<String> list,ArrayList<ArrayList<String>> result){
        //base case
        if(i==s.length()){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int k=i;k<s.length();k++){
            //check if  partition is possible or not
            if(isPalindrome(s,i,k)){
                list.add(s.substring(i,k+1));
                partition(s, k+1, list,result);
                list.remove(list.size()-1);
            }
        }
        
    }
    static boolean isPalindrome(String s,int start,int end){
        int left=start;
        int right=end;

        while(left<=right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        String s="a";
        System.out.println(allPalindromicPerms(s));
    }
}
