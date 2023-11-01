package DSA_programs.LaunchHashmap;

import java.util.HashSet;

public class UnionOfTwoArrays {
    public static void union(int[] arr1, int[] arr2){
        //Hashset stores only unique element
        HashSet<Integer> set = new HashSet<>();
        //add all the lement of the first array in the hashset
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        //Now add all the element of the Second array
        for(int i=0;i<arr2.length;i++){
            set.add(arr2[i]);
        }
        //print the Hashset
        System.out.println(set);
    }
    public static void main(String[] args) {
        int arr1[] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4};
        union(arr1, arr2);
    }
}
