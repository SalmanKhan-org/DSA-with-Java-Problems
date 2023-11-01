package DSA_programs.IntroToDP_dynamicProgramming;
import java.util.*;
public class RussianDoll {
    //Time complexity=O(N*logN)
    //Space complexity=O(N)
    public static int maxEnvelopes(int[][] envelope) {
        //sort the Array in increasing order of width and decreasing order of height if 
        //width is same
        Arrays.sort(envelope,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                return (a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
            }
        });

        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(envelope[0][1]);
        for(int i=1;i<envelope.length;i++){
            if(envelope[i][1]>ans.get(ans.size()-1)){
                ans.add(envelope[i][1]);
            }else{
                int low=Collections.binarySearch(ans,envelope[i][1]);

                if(low<0){
                    low=-(low+1);
                }
                ans.set(low,envelope[i][1]);
            }
        }
        return ans.size();
    }
    public static void main(String[] args) {
        int[][] envelopes={{5,4},{6,4},{6,7},{2,3}};
        System.out.println(maxEnvelopes(envelopes));
    }
}
