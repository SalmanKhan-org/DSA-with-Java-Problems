package DSA_programs.IntroToTrees.BinaryTree;
class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data =  data;
        left=right=null;
    }
}

public class MaxPathInaTree {
    static  int max=Integer.MIN_VALUE;
    private static int MaxPath(Node root){
        helper(root);
        return  max;
    }
    private static int helper(Node root){
        //root node is null then maximum path sum is zero
        if(root==null)  return 0;
        //call to left node is left node is negative then return only node itselt
        int left  =  Math.max(0,helper(root.left));
        //call to right node is left node is negative then return only node itselt
        int right = Math.max(0,helper(root.right));
        //compute the maximum sum
        max  = Math.max(max,root.data+left+right);
        //every node  will return sum of own data and maximum of  left  or right node;
        return root.data+Math.max(left, right);
    }
    public static void main(String[] args) {
        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        //root.left.left = new Node(4);
        //root.left.right = new Node(3);
        root.right.left = new Node(15);
        root.right.right = new Node(10);
        //root.right.left.left = new Node(7);
        //root.right.left.right = new Node(8);
        System.out.println("The Maximum path  sum is:"+MaxPath(root));
}
}