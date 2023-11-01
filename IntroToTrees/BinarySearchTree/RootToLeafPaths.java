package DSA_programs.IntroToTrees.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPaths {
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
    private static List<List<Integer>> printAllPaths(Node root,List<List<Integer>> list,List<Integer>  l){
        if(root == null) return list;

        l.add(root.data);
        if(root.left == null&&root.right==null){
            list.add(new ArrayList<>(l));
        }
        printAllPaths(root.left, list, l);
        printAllPaths(root.right, list, l);
        //backtrack
        l.remove(l.size()-1);

        return list;
    }
    public static void main(String[] args) {
        int[]  values  = {8,5,10,11,3,6,14};
        Node  root = null;
        for(int i=0;i<values.length;i++){
            root  =  insertInBST(root, values[i]);
        }
        List<List<Integer>> list=printAllPaths(root, new ArrayList<>(), new ArrayList<>());
        System.out.println(list);




























         
    }
}
