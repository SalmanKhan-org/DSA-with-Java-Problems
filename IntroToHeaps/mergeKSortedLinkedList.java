package DSA_programs.IntroToHeaps;
import java.util.*;
 class ListNode {
         int val;
         ListNode next;
        ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
public class mergeKSortedLinkedList {
    class compare implements Comparator<ListNode>{
        public int compare(ListNode a,ListNode b){
            if(a.val<b.val){
                return -1;
            }else if(a.val==b.val){
                return 0;
            }
            return 1;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> minHeap=new PriorityQueue<ListNode>(new compare()); 
        if(lists.length==0){
            return null;
        }
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null){
                minHeap.add(lists[i]);
            }
        }
        ListNode head=null;
        ListNode tail=null;
        while(minHeap.size()>0){
            ListNode top=minHeap.remove();
            if(top.next!=null){
                minHeap.add(top.next);
            }
            if(head==null){
                head=top;
                tail=top;
            }else{
                tail.next=top;
                tail=tail.next;
            }
        }
        return head;
    }
}
