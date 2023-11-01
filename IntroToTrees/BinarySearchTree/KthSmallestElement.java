package DSA_programs.IntroToTrees.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KthSmallestElement {
    static int ans=0;
    static int i=0;
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
    public static int kthSmallest(Node root,int k){
        solve(root,k);
        return ans;
    }
    private static void solve(Node root, int k) {
        if(root==null) return ;
        solve(root.left, k);
        i++;
        if(i==k){
           ans=root.data;
        }
        solve(root.right, k);
    }
    // public static List<Integer> inorderTraversal(Node root,List<Integer> list){
    //     if(root==null) return list;

    //     inorderTraversal(root.left,list);
    //     list.add(root.data);
    //     inorderTraversal(root.right,list);
    //     return list;
    // }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[]  values  = {8,5,10,11,14,3,6,4,1};
        Node  root = null;
        for(int i=0;i<values.length;i++){
            root  =  insertInBST(root, values[i]);
        }
        System.out.println("Before deletion of the element:");
        //List<Integer> list= inorderTraversal(root,new ArrayList<>());
        System.out.println("Enter the kth value:");
        int k=sc.nextInt();
        System.out.println("The "+k+"th Smallest element is:"+kthSmallest(root, k));
        
    }
}
