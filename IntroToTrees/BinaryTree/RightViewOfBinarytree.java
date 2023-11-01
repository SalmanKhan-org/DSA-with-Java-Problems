package DSA_programs.IntroToTrees.BinaryTree;

import java.util.ArrayList;
class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data =  data;
        left  = right  =  null;
    }
} 
public class RightViewOfBinarytree {
    static void rightViewOfTree(Node root,ArrayList<Integer> ans,int lvl){
        if(root==null) return;
        if(lvl==ans.size()){
            System.out.print(root.data+" ");
            ans.add(root.data);
        }
        rightViewOfTree(root.right,ans,lvl+1);
        rightViewOfTree(root.left,ans,lvl+1);
    }
    //Function to return list containing elements of right view of binary tree.
    static ArrayList<Integer> rightView(Node node) {
        ArrayList<Integer> ans =  new ArrayList<>();
        rightViewOfTree(node,ans,0);
        return ans;
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
        rightView(root);
    }
}
