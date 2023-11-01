package DSA_programs.IntroToTrees.BinarySearchTree;
import java.util.*;
public class BuiltBinarySearchTree {
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
    public static void inorderTraversal(Node root){
        if(root==null) return;

        inorderTraversal(root.left);
        System.out.print(root.data+" ");
        inorderTraversal(root.right);
    }
    public static void main(String[] args) {
        int[]  values  = {5,1,3,2,4,7};
        Node  root = null;
        for(int i=0;i<values.length;i++){
            root  =  insertInBST(root, values[i]);
        }

        inorderTraversal(root);
    }
}
