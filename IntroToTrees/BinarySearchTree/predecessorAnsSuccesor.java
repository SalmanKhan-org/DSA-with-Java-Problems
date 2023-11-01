package DSA_programs.IntroToTrees.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class predecessorAnsSuccesor {
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
        public static List<Integer> predecessorSuccessor(Node root, int key) {
            List<Integer> l=new ArrayList<>();
            int pred=-1;
            int succ=-1;
           Node temp=root;
           while(temp.data!=key){
               if(temp.data>key){
                   succ=temp.data;
                   temp=temp.left;
               }else{
                   pred=temp.data;
                   temp=temp.right;
               }
           }
           if(temp.left!=null){
               Node leftTree=temp.left;
               while(leftTree!=null){
                   pred=leftTree.data;
                   leftTree=leftTree.right;
               }
           }
           if(temp.right!=null){
               Node rightTree=temp.right;
               while(rightTree!=null){
                   succ=rightTree.data;
                   rightTree =rightTree.left;
               }
           }
           l.add(pred);
           l.add(succ);
           return l;
       }
        public static void main(String[] args) {
            int[]  values  = {5,1,3,2,4,7};
            Node  root = null;
            for(int i=0;i<values.length;i++){
                root  =  insertInBST(root, values[i]);
            }
            inorderTraversal(root);
            List<Integer> l = predecessorSuccessor(root, 2);
            System.out.println(l);
        }
}
