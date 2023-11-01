package DSA_programs.IntroToTrees.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data =  data;
        left  = right  =  null;
    }
}
public class LeftViewOfBinaryTree {
    static void leftView(Node root)
    {
      //ArrayList<Integer> ar = new ArrayList<>();
      Queue<Node> q = new LinkedList<>();
      if(root==null) return ;
      q.add(root);
      while(!q.isEmpty()){
          int size = q.size();
          for(int i=1;i<=size;i++){
              Node frontNode  = q.poll();
              if(i==1){
                  System.out.print(frontNode.data);
              }
              if(frontNode.left!=null) q.add(frontNode.left);
              if(frontNode.right!=null) q.add(frontNode.right);
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
        leftView(root);
    }
}
