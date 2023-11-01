package DSA_programs.IntroToHeaps;

import java.util.ArrayList;

public class BSTtoMaxHeap {
    static class Node{
        int data;
        Node left;
        Node  right;
        Node(int data){
            this.data=data;
            left=right=null;
        }
    }
    private static ArrayList<Integer> inOrder(Node root,ArrayList<Integer> inOrder){
        if(root==null) return  inOrder;
        
        inOrder(root.left,inOrder);
        inOrder.add(root.data);
        inOrder(root.right,inOrder);
        
        return inOrder;
    }
    static int index;
    private static void fillPostOrder(Node root,ArrayList<Integer> inOrder){
        if(root==null) return;
        
        fillPostOrder(root.left,inOrder);
        fillPostOrder(root.right,inOrder);
        root.data=inOrder.get(index++);
    }
    public static void convertToMaxHeapUtil(Node root)
    {
        index=0;
       ArrayList<Integer> inOrder=inOrder(root,new ArrayList<>());
       fillPostOrder(root,inOrder);
       
    }
}
