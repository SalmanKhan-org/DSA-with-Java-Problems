package DSA_programs.DevideAndConquerAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Interval{
    int start;
    int end;
    public Interval(int  start,int end){
        this.start =start;
        this.end=end;
    }
}
public class intervalIntersect {
    private static boolean intervalIntersection(List<Interval> intervals){
        //if the size of interval list is 1 or 0 then it is already overlaped;
        if(intervals.size()<2) return true;
        //sort the list based on start point then we will be able to find the overlaped lists
        Collections.sort(intervals, (a,b)->Integer.compare(a.start, b.start));
        //take start and end time of 0th list
        Interval temp=intervals.get(0);
        int start = temp.start;
        int end=temp.end;

        for(int i=1;i<intervals.size();i++){
            temp = intervals.get(i);
            if(temp.start<=end) return true;
            else{
                start = temp.start;
                end= temp.end;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 3));
        input.add(new Interval(7, 9));
        input.add(new Interval(4, 6));
        input.add(new Interval(10, 13));

        System.out.println(intervalIntersection(input));
    }
}
