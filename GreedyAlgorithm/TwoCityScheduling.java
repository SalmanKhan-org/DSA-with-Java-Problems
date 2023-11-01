package DSA_programs.GreedyAlgorithm;

import java.util.Arrays;

public class TwoCityScheduling {
    public static int twoCitySchedCost(int[][] costs){
        Arrays.sort(costs,(a,b)->
        {
            return (a[0]-a[1])-(b[0]-b[1]);
        });
        int cost=0;
        for(int i=0;i<costs.length/2;i++){
             cost+=costs[i][0]+costs[i+(costs.length/2)][1];
        }
        return cost;
    }
    public static void main(String[] args) {
        int[][] costs={{10,20},{30,200},{40,500},{30,20}};
        System.out.println(twoCitySchedCost(costs));
    }
}
