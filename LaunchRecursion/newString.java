package DSA_programs.LaunchRecursion;

public class newString {
   public static String newStr = "";
   public static int countX = 0;
   public static void moveAllX(int i,String str){
    //Base case
    if(i == str.length()){
        for(int j=0;j<countX;j++){
            newStr+='x';
        }
        System.out.println(newStr);
        return;
    }
    char curChar = str.charAt(i);
    if(curChar == 'x'){
        countX++;
    }else{
        newStr +=curChar;
    }
    moveAllX(i+1, str);
   }
    public static void main(String[] args) {
        String str = "xxxxxxabcd";
        moveAllX(0,  str);
    }
}
