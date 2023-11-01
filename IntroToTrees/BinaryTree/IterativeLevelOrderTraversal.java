package DSA_programs.IntroToTrees.BinaryTree;
import java.util.*;
class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data =  data;
        left=right=null;
    }
}
public class IterativeLevelOrderTraversal {
    static ArrayList <Integer> levelOrder(Node node) 
    {
        ArrayList<Integer> al = new ArrayList<>();
        //if node is poiting to null
        if(node==null){
            return al;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            Node n = q.remove();
            al.add(n.data);
            
            if(n.left!=null) q.add(n.left);
            
            if(n.right!=null) q.add(n.right);
        }
        return al;
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
        System.out.println(levelOrder(root));
    }
}
