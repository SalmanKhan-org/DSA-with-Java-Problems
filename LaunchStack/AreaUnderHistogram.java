package DSA_programs.LaunchStack;

import java.util.Arrays;

public class AreaUnderHistogram {
    public static  void largetArea(int[] heights){
        int n=heights.length;
        int[] prev_Small =  new int[n];
        int[] next_Small =  new int[n];
        prev_Small[0]=-1;
        next_Small[n-1] =n;
        //for finding the previous smaller element
        for(int i=1;i<n;i++){
            int prev = i-1;
            while(prev >= 0 && heights[prev] >= heights[i]){
                prev = prev_Small[prev]; // we have done this to minimise the jumps we make to the left
                //prev--;
            }
            prev_Small[i] = prev;      
        }
        //for finding the next Smaller element
        for(int i=n-2;i>=0;i--){
            int next = i+1;
            while(next<n&&heights[next]>=heights[i]){
                next =  next_Small[next];
                //next++;
            }
            next_Small[i] =  next;
        }
        int max_Area =0;
        for(int i=0;i<n;i++){
            int width =  next_Small[i]-prev_Small[i]-1;
            max_Area =  Math.max(max_Area, width*heights[i]);
        }
        System.out.println("Maximum Area under histogram is:"+max_Area);
    }
    public static void main(String[] args) {
        int[] heights = {4,2,1,5,6,3,2,4,2};
        largetArea(heights);
    }

}
