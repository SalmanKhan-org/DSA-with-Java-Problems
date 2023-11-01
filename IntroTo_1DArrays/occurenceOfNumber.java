package DSA_programs.IntroTo_1DArrays;
import java.util.*;
public class occurenceOfNumber {
    //Time complexity=o(N)
    //Space complexity=O(N)
    public static void main(String[] args) {
                int arr[] = {2,3,5,2,2,3,6,8};
                int x = 3;
                ArrayList<Integer> clist = new ArrayList();
                for(int i:arr){
                    clist.add(i);
                }
                int occurence = Collections.frequency(clist,x);
                System.out.println("The occurence of "+x+" is :"+occurence);
            }
}
