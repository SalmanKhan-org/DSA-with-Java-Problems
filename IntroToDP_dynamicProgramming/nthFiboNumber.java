package DSA_programs.IntroToDP_dynamicProgramming;
import java.util.*;
public class nthFiboNumber {
    public int fibo(int n,int dpArr[]){
        //base  case
        if(n<=1){
            return n;
        }
        if(dpArr[n]!=-1){
            return dpArr[n];
        }
        dpArr[n]=fibo(n-1,dpArr)+fibo(n-2,dpArr);
        return dpArr[n];
    }
    public int fib(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return fibo(n,dp);
    }
}
