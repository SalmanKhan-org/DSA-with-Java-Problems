package DSA_programs.IntroToDP_dynamicProgramming;
import java.util.*;
public class LongestIncreasingSubSequences4 {
    //Time  complexity=O(N*LogN)
    public static int lengthOfLIS(int[] nums) {
        int size=nums.length;
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(nums[0]);
        
        for(int i=1;i<size;i++){
            if(nums[i]>ans.get(ans.size()-1)){
                ans.add(nums[i]);
            }else{
                int low=Collections.binarySearch(ans,nums[i]);
                if(low<0){
                    low=-(low+1);
                }
                ans.set(low,nums[i]);
            }
        }
        return ans.size();
    }
    public static void main(String[] args) {
        int[] a={2,3,5,6,8,4,3,2};
        System.out.println(lengthOfLIS(a));
    }
}
