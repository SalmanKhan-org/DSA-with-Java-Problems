package DSA_programs.GreedyAlgorithm;

public class MinimumSumOfProductOfTwoArrays {
    public static int minimizeProductSum(int[] A, int[] B, int n,int k){
        int pro=0,sum=0,modPro=0,currMax=0,absDiff=0;
        for(int i=0;i<n;i++){
            pro=A[i]*B[i];
            sum+=pro;

            if(pro<0&&B[i]<0) modPro=(A[i]+2*k)*B[i];
            if(pro<0&&A[i]<0) modPro=(A[i]-2*k)*B[i];
            if(pro>0&&A[i]>0) modPro=(A[i]-2*k)*B[i];
            if(pro>0&&A[i]<0) modPro=(A[i]+2*k)*B[i];

            absDiff=Math.abs(pro-modPro);
            if(absDiff>currMax){
                currMax=absDiff;
            }
        }
        return sum-currMax;
    }
    public static void main(String[] args) {
        int[] A={1,2,-3};
        int[] B={-2,3,-5};
        System.out.print("The minimum sumof product of two Arrays:"+minimizeProductSum(A, B, A.length, 2));
    }
}
