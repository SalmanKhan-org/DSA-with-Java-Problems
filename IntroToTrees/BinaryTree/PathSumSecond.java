package DSA_programs.IntroToTrees.BinaryTree;
import java.util.*;
class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data = data;
        left=right=null;
    }
}
public class PathSumSecond {
   // static List<Integer> l =  new LinkedList<>();
    private static void solvePathSum(Node root,List<List<Integer>> list,List<Integer> l,int targetSum,int sum){
        if(root==null) return;
        l.add(root.data);
        if(root.left==null&&root.right==null&&sum+root.data==targetSum){
            list.add(new ArrayList<>(l));
        }
        solvePathSum(root.left, list, l, targetSum, sum+root.data);
        solvePathSum(root.right, list, l, targetSum, sum+root.data);
        l.remove(l.size()-1);
    }
    public static List<List<Integer>> pathSum(Node root,int targetSum){
        List<List<Integer>> list = new LinkedList<>();
        List<Integer> l = new LinkedList<>();
        solvePathSum(root,list,l,targetSum,0);

        return list;
    }
    public static void main(String[] args) {
        Node root =  new Node(5);
        root.left = new Node(4);
        root.left.left = new Node(11);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(2);
        root.right =  new Node(8);
        root.right.left = new Node(13);
        root.right.right = new  Node(4);
        root.right.right.left = new Node(5);
        root.right.right.right = new Node(1);
        List<List<Integer>> list =  pathSum(root, 22);
       System.out.print(list+" ");
    }
}
