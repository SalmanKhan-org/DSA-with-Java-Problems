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
public class DiagonalTraversalofTree {
    public static void diagonal(Node root)
      {
           //ArrayList<Integer> ar = new ArrayList<>();
           Queue<Node> q= new LinkedList<>();
           if(root==null) return ;
           q.add(root);
           while(!q.isEmpty()){
               Node frontNode = q.poll();
               while(frontNode!=null){
                   if(frontNode.left!=null) q.add(frontNode.left);
                   System.out.print(frontNode.data);
                   frontNode =  frontNode.right;
               }
           }
           //return ar;
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
        diagonal(root);
    }
}
