package DSA_programs.LaunchRecursion;

public class printMultiple {
    public static void printMul(int n, int k){
        if(k==0){
            return;
        }
        printMul(n,k-1);
        System.out.print(n*k+" ");
    }
    public static void main(String[] args) {
        int n = 12;
        int k=4;
        printMul(n,k);
    }
}
