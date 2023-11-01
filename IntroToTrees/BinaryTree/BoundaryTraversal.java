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
public class BoundaryTraversal {
    private static void leftTraversal(Node root,List<Integer> ans){
        //if we find any null node and leaf node then we have to return simply
        if((root==null)||root.left==null&&root.right==null){
            return;
        }
        ans.add(root.data);
        if(root.left != null){
            leftTraversal(root.left, ans);
        }else{
            leftTraversal(root.right, ans);
        }

    }
    private static void leafTraversal(Node root, List<Integer> ans){
        if(root==null) return;
        if(root.left==null&&root.right==null){
            ans.add(root.data);
            return;
        }
        leafTraversal(root.left, ans);
        leafTraversal(root.right, ans);
    }
    private static void rightTraversal(Node root,List<Integer> ans){
        if((root==null)||root.left==null&&root.right==null){
            return;
        }
        if(root.right!=null) rightTraversal(root.right, ans);
        else{
            rightTraversal(root.left, ans);
        }
        ans.add(root.data);

    }
    private static List<Integer> boundaryTraversalInTree(Node root){
        List<Integer> ans = new LinkedList<>();
        //left boundary traversal
        leftTraversal(root,ans);
        //leaf traversal
        leafTraversal(root,ans);
        //right traversal
        if(root!=null){
        rightTraversal(root.right,ans);
        }
        return ans;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(8);
        root.right  = new Node(4);
        root.right.right  = new Node(7);
        root.right.right.right = new Node(9);
        root.right.right.right.left = new Node(10);
        root.right.right.right.right = new Node(11);
        List<Integer> ans= boundaryTraversalInTree(root);
        for(int i:ans){
            System.out.print(i+" ");
        }
    }
}
