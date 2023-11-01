package DSA_programs.GreedyAlgorithm;

import java.util.*;
import java.util.Collections;
import java.util.Comparator;
import java.lang.*;
class meetings<T1,T2>{
    T1 start;
    T2  end;
    meetings(T1 start ,T2 end){
        this.start = start ;
        this.end = end;
    }
}
class EndSorter implements Comparator<meetings>{

    @Override
    public int compare(meetings o1, meetings o2) {
        if((int)o1.end < (int)o2.end){
            return -1;
        }else if((int)o1.end>(int)o2.end)
            return 1;
        return 0;
       
    }
    
}
public class NMeetingsInRoom {

    public static int maxMeetings(int start[], int end[], int n)
    {
        //Add start time and end  time  in a list
        ArrayList<meetings>  al =  new ArrayList<>();
        for(int i=0;i<n;i++){
            al.add(new meetings(start[i], end[i]));
            //al.add(l);
        }
        EndSorter es =new EndSorter();
        Collections.sort(al,es);
        int count=1;
        int ends  =  (int) al.get(0).end;
        for(int i=1;i<al.size();i++){
            if((int)al.get(i).start>ends){
                count++;
                ends =(int)al.get(i).end;
            }
        }
        return   count;
    }
    public static void main(String[] args) {
        int[] start  = {1,3,0,5,8,5};
        int[] end = {2,4,6,7,9,9};
        System.out.println(maxMeetings(start, end, end.length)); 
    }
}
