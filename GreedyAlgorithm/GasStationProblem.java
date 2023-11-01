package DSA_programs.GreedyAlgorithm;

public class GasStationProblem{
    public static int canCompletetour(int[] gas,int[] dist){
        if(gas.length==1) return 0;

        int def=0,fuel=0,start=0;
        for(int i=0;i<gas.length;i++){
            fuel += gas[i]-dist[i];
            if(fuel<0){
                def+=fuel;
                fuel=0;
                start=i+1;
            }
        }
        if(fuel+def >=0) return start;

        return -1;
    }
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] dist = {3,4,5,1,2};
        System.out.println("The starting from where we can complete the circle:"+canCompletetour(gas, dist));
    }
}