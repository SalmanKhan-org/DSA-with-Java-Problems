package DSA_programs.LaunchQueue;

public class cycleTour {
    //Time complexity = O(N)
    //space complexty =  O(1) because we are not using any extra space
    public static int possibleCycle(int[] petrol,int[]  distance,int n){
        int bal=0;
        int deficit=0;
        int front = 0;
        int rear =0;
        for(int i=0;i<n;i++){
            bal += petrol[i]-distance[i];
            if(bal<0){//travel is not possible
                deficit+=bal;
                front = rear+1;
                rear= front;
                bal = 0;
            }else{
                rear++;
            }
        }
        if(deficit+bal>=0){
            return  front;
        }else{
            return -1;
        }
    }            
    public static void main(String[] args) {
        int[] p={6,7,4,10,6,5};
        int[] d={5,6,7,8,6,4};
        System.out.println("Travel is possible and the starting point is:"+possibleCycle(p, d, p.length));
    }
}
