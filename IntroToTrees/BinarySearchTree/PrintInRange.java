package DSA_programs.IntroToTrees.BinarySearchTree;

import java.util.LinkedList;
import java.util.List;

public class PrintInRange {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data =  data;
            left = right =  null;
        }
    }
    public static Node insertInBST(Node root,int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data>val){
            root.left =  insertInBST(root.left, val);
        }else{
            root.right =  insertInBST(root.right, val);
        }
        return root;
    }
    private static List<Integer> printValuesInRange(Node root,List<Integer> list,int x,int y){
        if(root==null){
           return list;
       }
       if(root.data>=x&&root.data<=y){
           printValuesInRange(root.left, list, x, y);
          list.add(root.data);
           printValuesInRange(root.right, list, x, y); 
       }else if(root.data>=y){
          printValuesInRange(root.left, list, x, y);
       }else{
          printValuesInRange(root.right, list, x, y); 
       }
       return list;
   }
    public static void main(String[] args) {
        int[]  values  = {8,5,10,11,3,6,1,4,14};
        Node  root = null;
        for(int i=0;i<values.length;i++){
            root  =  insertInBST(root, values[i]);
        }
       List<Integer> list=printValuesInRange(root, new LinkedList<>(), 6, 10);
       System.out.println(list);
    }
}
