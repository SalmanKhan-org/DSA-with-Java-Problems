package DSA_programs.DevideAndConquerAlgo;

import java.util.Arrays;

public class permuteSumEqualToK {
    //overAll time complexity will be O(nlogn)
    //And Auxillary space will be O(1)
    private static boolean permuteSum(int[] A1,int[] A2,int k){
        //T(n)->O(nlogn)
        Arrays.sort(A1);
        //T(n)->O(nlogn)
        Arrays.sort(A2);
        int low=0,high=A2.length-1,count=0;
        //T(n)->n
        while(low!=A1.length){
            if(A1[low]+A2[high]>=k){
                count++;
            }
            low++;high--;
        }
        if(count==A1.length) return  true;

        return false;
    }
    public static void main(String[] args) {
        int[] arr1 = {1,2,2,1};
        int[] arr2={3,3,3,4};
        int k=10;
        System.out.println(permuteSum(arr1, arr2, k));
    }
}
