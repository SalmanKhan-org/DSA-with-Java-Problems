package DSA_programs.GreedyAlgorithm;

import java.util.Arrays;

public class removeOverlapIntervals {
        public static int eraseOverlapIntervals(int[][] intervals) {
             Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
            for(int[] i:intervals){
                for(int j:i){
                    System.out.print(j+" ");
                }  
            }
             int[] curr = new int[] {intervals[0][0], intervals[0][1]};
             int maxCap = 0;
             for (int i = 1; i < intervals.length; i++) {
                 if (intervals[i][0] < curr[1]){
                 curr[0] = intervals[i][0];
                 curr[1] = intervals[i][1];
                 maxCap++;
                 }
             }
             return maxCap;
         }
         public static void main(String[] args){
             int[][] intervals = {{1,100},{11,22},{1,11},{2,12}};
            // int n = 1;
             System.out.println("The desired output is :  " + eraseOverlapIntervals(intervals));
         }
}
