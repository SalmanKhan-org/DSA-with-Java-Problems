package DSA_programs.GreedyAlgorithm;

import java.util.Arrays;

public class BagOfTokens {
    public static int bagOfTokensScore(int[] tokens, int power){
        Arrays.sort(tokens);
        int low=0,high=tokens.length-1,score=0,maxScore=0;
        while(low<=high){
            if(tokens[low]<=power){
                score++;
                power-=tokens[low];
                low++;
                maxScore=Math.max(maxScore,score);
            }else if(score>0){
                score--;
                power+=tokens[high];
                high--;
            }else{
                break;
            }
        }
        return maxScore;
    }
    public static void main(String[] args) {
        int[] tokens={100};
        int power=50;
        System.out.println("The maximum score is:"+bagOfTokensScore(tokens, power));
    }   
}
