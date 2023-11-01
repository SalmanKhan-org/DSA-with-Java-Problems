package DSA_programs.LaunchRecursion;

import java.util.Scanner;

public class firstLastOccur {
    public static int first = -1;
    public static int last = -1;
    public static void firstLastOccurence(int i, String str, char ch){
        if(i<0){
            System.out.println("First occurence of "+ch+" is found at index: "+first);
            System.out.println("last occurence of "+ch+" is found at index: "+last);
            return;
        }
        char curChar = str.charAt(i);
        if(curChar == ch){
            if(last == -1){
                last = i;
            }else{
                first = i;
            }
        }
        firstLastOccurence(i-1, str, ch);
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String str = "abcdeafbgah";
        //int idx = 0;
        char ch = 'a';
        firstLastOccurence(str.length()-1,str,ch);

    }
}
