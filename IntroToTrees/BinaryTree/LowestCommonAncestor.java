package DSA_programs.IntroToTrees.BinaryTree;
class Node{
    int data;
    Node left,right;
    public Node(int data){
        this.data=data;
        left=right=null;  
    }
}
public class LowestCommonAncestor {
    public static Node  lowestCommonAncesto(Node root,Node p,Node q){
        //if root is null then return null
        if(root==null) return null;
        //if we found one of the p and q then return root istselt
        if(root==p || root==q) return root;
        //left call
        Node left =  lowestCommonAncesto(root.left, p, q);
        //right call
        Node right =lowestCommonAncesto(root.right, p, q);
        //if left and right both are not equal to null  means p and q are found then return  root node
        if(left != null&& right != null){
            return root;
        } 
        if(left!=null){
            return left;
        }else{
            return right;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        //root.left.left = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        root.right.left.left = new Node(8);
        root.right.right.left = new Node(6);
        root.right.right.right = new Node(7);
        //root.right.right.right = new Node(8);

        Node LCA=lowestCommonAncesto(root,root.right.left.left ,  root.right.right.right);
        System.out.println(LCA.data);
   }
}
