package DSA_programs.LaunchRecursion;

public class reverseString {
    //public static String str1 = "";
    public static void reverseStr(int n, String str){
        //base case
        if(n<0){
            //System.out.println(rStr);
            return;
        }
        System.out.print(str.charAt(n));
        reverseStr(n-1, str);
    }

    public static void main(String[] args) {
        String str = "salman";
        int i=str.length();
        reverseStr(i-1,str);
    }
}
