package DSA_programs.GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Interval{
    int start;
    int end;
    public Interval(int start, int end){
        this.start =  start;
        this.end = end;
    }
}
public class mergeIntervals {
    private static List<Interval> mergedIntervals(List<Interval> list){
        //if sizeis less than two then it is already merge
        if(list.size()<2) return list;
        //create a list of intervals to store the mergedIntervals
        List<Interval> l = new ArrayList<>();
        //sort the list of intevals based on  the start time
        Collections.sort(list,(a,b)->Integer.compare(a.start,b.start));
        //Initialize the start and end variable with oth start and end
        Interval temp =  list.get(0);
        int start= temp.start;
        int end = temp.end;
        //traverse the rest of the list of intervals;
        for(int i=1;i<list.size();i++){
            temp = list.get(i);
            //if find the overlap then  update the end 
            if(end>=temp.start){
                end = Math.max(end, temp.end);
                //if doesnot find the ovrlap the add the last overlaped intervals
            }else{
                l.add(new Interval(start, end));
                start = temp.start;
                end = temp.end;
            }
        }
        //At the end of the loop one Intervals will be left add this to  list also
        l.add(new Interval(start, end));
        return l;
    }
    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 3));
        input.add(new Interval(2, 6));
        input.add(new Interval(7, 8 ));
        input.add(new Interval(10, 13));

        List<Interval> l = mergedIntervals(input);
        for(Interval i:l){
            System.out.print("["+i.start+","+i.end+"]");
        }
    }
}
