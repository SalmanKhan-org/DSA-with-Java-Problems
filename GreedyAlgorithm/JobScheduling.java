package DSA_programs.GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

class JobItems{
    int id,deadline,profit;
    JobItems(int id,int deadline,int profit){
        this.id=id;
        this.deadline=deadline;
        this.profit=profit;
    }
}
public class JobScheduling {
    private static void printJobSequences(ArrayList<JobItems> arr,int deadline){
        //sort the ArrayList according to profit
        Collections.sort(arr, new Comparator<JobItems>() {
            @Override
            public int compare(JobItems item1, JobItems  item2){
               int val1 =item1.profit;
                int  val2 = item2.profit;
                if(val1<val2) {
                    return 1;
                }else{
                    return -1;
                }
            }
        });
        //create a array of size max deadline to store the joSequences
        int[] jobs = new int[deadline];
        //create a array to track the jobSequences
        boolean[] result = new boolean[deadline];
        //travese the arralist
        for(int i=0;i<arr.size();i++){
            for(int j=Math.min( deadline-1, arr.get(i).deadline-1);j>=0;j--){
                if(result[j]==false){
                    result[j]=true;
                    jobs[j]  = arr.get(i).id;
                    break;
                }
            }
        }
        for(int i:jobs){
            System.out.print(i+" ");
        }
    }
    public static void main(String[] args) {
        ArrayList<JobItems> arr = new ArrayList<>();
        arr.add(new JobItems(1, 2, 100));
        arr.add(new JobItems(2, 1, 19));
        arr.add(new JobItems(3, 2, 27));
        arr.add(new JobItems(4, 1, 25));
        arr.add(new JobItems(5, 3, 15));

        System.out.println("The Job sequences to get the highest profit:");
        printJobSequences(arr, 3);
    }
}
