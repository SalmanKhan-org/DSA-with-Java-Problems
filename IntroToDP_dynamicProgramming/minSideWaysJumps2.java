package DSA_programs.IntroToDP_dynamicProgramming;

public class minSideWaysJumps2 {
    //Approach -4 Space  optimization 
    //Time comPlexity=O(3*N*3) where N refers to Number  of position
    public static int minJumps(int[] obstacles){
        int n=obstacles.length;
        int[] curr=new  int[4];
        int[] next=new int[4];
        //Analyze base case
        next[0]=0;
        next[1]=0;
        next[2]=0;
        next[3]=0;

        for(int pos=n-2;pos>=0;pos--){
            for(int curlane=1;curlane<=3;curlane++){
                if(obstacles[pos+1]!=curlane){
                    curr[curlane]=next[curlane];
                }else{
                    int ans=Integer.MAX_VALUE;
                    for(int i=1;i<=3;i++){
                        if(curlane!=i&&obstacles[pos]!=i){
                        ans=Math.min(ans,1+next[i]);
                    }
                }
                curr[curlane]=ans;
            }
            next=curr;
        }
        }
        return Math.min(next[2],Math.min(1+next[1],1+next[3]));
    }
    public static void main(String[] args) {
        int[] obstcles={0,1,2,3,0};
        System.out.println(minJumps(obstcles));
    }
}
