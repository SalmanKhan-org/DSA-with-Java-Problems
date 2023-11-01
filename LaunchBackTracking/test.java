package DSA_programs.LaunchBackTracking;
import java.util.*;
public class test {
    public static void backtrack(List<List<Integer>> result, List<Integer> temp, int[] candidates, int target,int idx){
        if(target == 0){
            result.add(new ArrayList<>(temp));
            return;
        }
            
        if(target<0){
                return;
        }
        for(int i=idx;i<candidates.length;i++){
            if(i>idx && candidates[i]==candidates[i-1])continue;
        temp.add(candidates[i]);
        backtrack(result, temp, candidates, target-candidates[i], idx+1);
        temp.remove(temp.size()-1);
        }
        
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result,new ArrayList<>(),candidates,target,0);
        return result ;
        
}
    public static void main(String[] args) {
        int[] arr = {2,5,2,1,2};
        int target =5;
       System.out.println( combinationSum2(arr,target));
    }
    
}
