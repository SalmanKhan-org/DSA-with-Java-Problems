package DSA_programs.IntroToTrees.BinarySearchTree;

import java.util.ArrayList;

public class flattenBSTtoSortedList {
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
    public static void inOrderTraversal(Node root,ArrayList<Node> ar)
    {
        if(root==null) return;
        inOrderTraversal(root.left, ar);
        ar.add(root);
        inOrderTraversal(root.right, ar);
    }
    public static Node flatten(Node root)
    {
        ArrayList<Node> ar  = new ArrayList<>();
        inOrderTraversal(root,ar);
        Node newNode = ar.get(0);
        Node cur  = newNode;
        for(int i=1;i<ar.size();i++){
            Node temp =ar.get(i);
            cur.left = null;
            cur.right=temp;
            cur=temp;
        }                                    
        cur.left=null;
        cur.right=null;

        return newNode;                                
    }
    public static void main(String[] args) {
        int[]  values  = {5,1,3,2,4,7};
        Node  root = null;
        for(int i=0;i<values.length;i++){
            root  =  insertInBST(root, values[i]);
        }
    }
}
