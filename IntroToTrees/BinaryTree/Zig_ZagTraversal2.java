package DSA_programs.IntroToTrees.BinaryTree;

import java.util.*;
class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data =  data;
        left  = right  =  null;
    }
}
public class Zig_ZagTraversal2 {
    private static void zigZagTraversal2(Node root){
        if(root==null) return;
        boolean leftToright=true;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            int[] ans = new int[size];
            for(int i=0;i<size;i++){
                Node node = q.poll();
                int index = leftToright? i :size-i-1;
                ans[index] = node.data;

                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            leftToright = !leftToright;
            for(int i:ans){
                System.out.print(i+" ");
            }
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
        zigZagTraversal2(root);
    }
}
