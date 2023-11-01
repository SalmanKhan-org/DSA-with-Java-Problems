package DSA_programs.LaunchHashmap;

import java.util.Arrays;
import java.util.HashSet;

public class IntersectionOfTwoArrays {
    public static void intersection(int[] nums1, int[] nums2){
        HashSet<Integer> set = new HashSet<>();
        // int n=1;
        // int[] intersec= new int[n];
        for(int i=0;i<nums1.length;i++){
            set.add(nums1[i]);
        }

        for(int i=0;i<nums2.length;i++){
            if(set.contains(nums2[i])){
               System.out.print(nums2[i]+" ");
                //n++;
                set.remove(nums2[i]);
            }
        }
        //return intersec;
    }
    public static void main(String[] args) {
        int[] nums1 = {7,3,9};
        int[] nums2 = {6,3,9,2,9,4};
        intersection(nums1, nums2);
        // int[] result  = intersection(nums1, nums2);
        // System.out.println(Arrays.toString(result));
    }
}