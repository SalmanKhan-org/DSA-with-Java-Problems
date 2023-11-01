package DSA_programs.GreedyAlgorithm;
import java.util.*;
import java.lang.*;

class Item{
    int profit;
    int weight;
    Item(int profit,int weight){
        this.profit=profit;
        this.weight=weight;
    }
}
public class FractionalKnapsack {
    //Time complexity = O(nlogN)
    //space complexity = O(1)
    public static double getMaxProfit(Item[] arr, int capacity){
        //sort the items based on profit/weight ratio
        Arrays.sort(arr, new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item  item2){
                double val1 = Double.valueOf(item1.profit/item1.weight);
                double  val2 = Double.valueOf(item2.profit/item2.weight);
                if(val1<val2) {
                    return 1;
                }else{
                    return -1;
                }
            }
        });
        double totalProfit=0;
        for(Item i:arr){
            int curPrft =(int)i.profit;
            int curWt =(int)i.weight;
            if(capacity-curWt>=0){
                capacity-=curWt;
                totalProfit+=curPrft;
            }else{
                double fraction=((double)capacity/(double)curWt);
                totalProfit+=(fraction*curPrft);
                capacity-=(int)(fraction*curWt);
                break;
            }
        }
        return totalProfit;
    }
    public static void main(String[] args) {
        Item[] arr = { new Item(60, 10),
                                     new Item(100, 20),
                                    new Item(120, 30) };
        // list.add(new Item(50, 4));
        // list.add(new Item(45, 7));
        // list.add(new Item(90, 9));
        // list.add(new Item(30, 3));
        int capacity = 50;
        System.out.println("The total profit is:"+getMaxProfit(arr,capacity ));
    }
}
