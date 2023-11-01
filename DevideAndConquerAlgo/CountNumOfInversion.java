package DSA_programs.DevideAndConquerAlgo;

import java.util.Arrays;

import javax.sound.midi.MidiChannel;
import javax.xml.crypto.dsig.spec.HMACParameterSpec;

public class CountNumOfInversion {
    //Time complexity=O(NlogN);
    //Space complexity=O(N) because  we are using the extra space to store the left subArray and rightSubArray
    private static int mergeProcedure(int[] arr, int l, int mid, int h){
        int swaps=0;
        int n1 = mid-l+1;
        //copy the element of the leftSubArray
        int[] lSubArray = new int[n1];
        for(int  i=0;i<n1;i++){
            lSubArray[i] = arr[l+i];
        }
        int[] rSubArray = Arrays.copyOfRange(arr, mid+1, h+1);

        int i=0,j=0,k=l;
        //compare the element of the left SubArray and right SubArray
        while(i<lSubArray.length&&j<rSubArray.length){
            if(lSubArray[i]<=rSubArray[j]){
                arr[k++]=  lSubArray[i++];
            }else{
                arr[k++] =  rSubArray[j++];
                swaps +=n1-i;
            }
        }
        //copy the remaining element of the leftSubArray into original Array
        while(i<lSubArray.length){
            arr[k++] = lSubArray[i++];
        }
        //copy the remaining element of the right subArray into original Array
        while(j<rSubArray.length){
            arr[k++] = rSubArray[j++];
        }
        return swaps;
    }
    private static int countInversions(int[] arr,int l, int h){
        int count=0;
        if(l<h){
            //1.devide the Array into two subproblems
            int mid = l+(h-l)/2;
            //2.Conquer two subProblems using devide and conquer algorithm
            //left SubArray and also count the number of inversions in left SubArray
            count+=countInversions(arr, l,mid);
            //right SubArray also count the number  of the  inversions in the right SubArray
            count+=countInversions(arr, mid+1,h);
            //3.Combine the Subproblems two  get the desired result
            count+=mergeProcedure(arr,l,mid,h);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int n = arr.length;
        System.out.println("The number of inversion in the given array using devide and conquer is:"
        +countInversions(arr, 0, n-1));
    }
}
