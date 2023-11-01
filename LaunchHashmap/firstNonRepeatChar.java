package DSA_programs.LaunchHashmap;

import java.util.HashMap;
import java.util.TreeMap;

public class firstNonRepeatChar {
    public static int firstNonRepeatingChar(String str){
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<str.length();i++){
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),map.get(str.charAt(i))+1);
            }else{
                map.put(str.charAt(i),1);
            }
        }
        int result= -1;
        for(int i=0;i<str.length();i++){
            if(map.get(str.charAt(i))==1){
                result= i;
                return result;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String str="alman";
        int result=firstNonRepeatingChar(str);
        if(result==-1){
            System.out.println("The given String does not conatain any unique Character:");
        }else{
            System.out.println("The first non repeating character found at index:"+result);
        }
        
    }
}
