package DSA_programs.LaunchHashmap;

import java.util.HashMap;
import java.util.Map;

public class RanSomNote {
    //time complexity= O(N1+N2) N1 for insering the values in rMap and N2 for Inserting values in mMap
    //Space complexity = O(M1+M2) M1 for rMap and M2 for mMap
    private static boolean canConstruct(String str1,String str2){
        HashMap<Character,Integer> rMap =new HashMap<>();
        for(int i=0;i<str1.length();i++){
            if(rMap.containsKey(str1.charAt(i))){
                rMap.put(str1.charAt(i),rMap.get(str1.charAt(i))+1);
            }else{
                rMap.put(str1.charAt(i), 1);
            }
        }
        HashMap<Character,Integer> mMap =new HashMap<>();
        for(int i=0;i<str2.length();i++){
            if(mMap.containsKey(str2.charAt(i))){
                mMap.put(str2.charAt(i),mMap.get(str2.charAt(i))+1);
            }else{
                mMap.put(str2.charAt(i), 1);
            }
        }
        //boolean flag = true;
        for(Map.Entry<Character, Integer> e:rMap.entrySet()){
            if(!mMap.containsKey(e.getKey())||e.getValue()>mMap.get(e.getKey())){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String ranSomNote="aa";
        String magazine="ab";
        boolean flag= canConstruct(ranSomNote,magazine);
        System.out.println(flag);
    }
}
