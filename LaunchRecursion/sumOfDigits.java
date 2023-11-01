package DSA_programs.LaunchRecursion;

public class sumOfDigits {
    public static int dig(int n){
        if(n == 0){
            return 0;
        }else{
            int sum  = n%10 +dig(n/10);
            return sum;
        }
    }
    public static void main(String[] args) {
        int n = 345;
        int result = dig(n);
        System.out.println("Sum of the given digits is:"+result);
    }
}
