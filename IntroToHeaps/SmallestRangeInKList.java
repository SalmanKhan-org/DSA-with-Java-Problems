package DSA_programs.IntroToHeaps;
import java.lang.reflect.Array;
import java.util.*;
public class SmallestRangeInKList {
    class Node{
        int row;
        int col;
        int data;
        Node(int d,int r,int c){
            this.data=d;
            this.row=r;
            this.col=c;
        }
    }
    class Compare implements Comparator<Node>{
        public int compare(Node o1, Node o2) {
            if(o1.data<o2.data){
                return -1;
            }else if(o1.data==o2.data){
               return 0;
            }
            return 1;
     }
}
    public int[] smallestRange(List<List<Integer>> nums) {
        int mini=Integer.MAX_VALUE,maxi=Integer.MIN_VALUE;
        Queue<Node> minHeap=new PriorityQueue<>(new Compare());
        for(int i=0;i<nums.size();i++){
            int element=nums.get(i).get(0);
            mini=Math.min(mini,element);
            maxi=Math.max(maxi,element);
            minHeap.add(new Node(element,i,0));
        }
        int strt=mini,end=maxi;
        while(minHeap.size()>0){
            Node temp=minHeap.remove();
            mini=temp.data;
            if(maxi-mini<end-strt){
                strt=mini;
                end=maxi;
            }
            if(temp.col+1<nums.get(temp.row).size()){
                maxi=Math.max(maxi,nums.get(temp.row).get(temp.col+1));
                minHeap.add(new Node(nums.get(temp.row).get(temp.col+1),temp.row,temp.col+1)
                );

            }else{
                break;
            }
        }
        return new int[]{strt,end};
    }
}
