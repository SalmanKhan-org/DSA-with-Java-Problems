package DSA_programs.LaunchRecursion;

public class uniqueCharString {
   public static String newStr = "";
   public static boolean[] map = new boolean[26];
   public static void removeDuplicate(int i,String str){
    if( i==str.length()){
        System.out.println(newStr);
        return;
    }
    if(map[str.charAt(i) - 'a']){
        removeDuplicate(i+1, str);
    }else if(map[str.charAt(i)-'a'] == false){
        newStr += str.charAt(i);
        map[str.charAt(i)-'a'] = true;
        removeDuplicate(i+1, str);
    }
   }
    public static void main(String[] args) {
        String str = "abbcaadee";
        removeDuplicate(0, str);
    }
}
