package DSA_programs.GreedyAlgorithm;

public class minimumCandyDistribute {
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] candy = new int[n];
        //first distribute 1candy to every children
        for(int i=0;i<n;i++){
            candy[i]=1;
        }
        //increment candy if current element greater than the previous
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                candy[i]=candy[i-1]+1;
            }
        }
        //now traverse from n-2 index and increment candy  if current element
        //is greter than the next element 
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]&&candy[i]<=candy[i+1]+1){
                candy[i]=candy[i+1]+1;
            }
        }
        //calculate sumof all candies
        int total_candy=0;
        for(int i=0;i<n;i++){
            total_candy+=candy[i];
        }
        return total_candy;
    }
    public static void main(String[] args) {
        int[] A = {1,3,3,2,2};
        System.out.println("The minimum candies distributed for the given number of children are:"+candy(A));
    }
}
