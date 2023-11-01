package DSA_programs.IntroToTrees.BinaryTree;
class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data =  data;
        left=right=null;
    }
}                                                                       
public class SymmetricTree {
        public static  boolean   checkIsSymmetric(Node left,Node right){
            //if both the left and right are null
             if(left==null && right==null)
                return true;
             if(left==null || right==null)
                return false;
             if(left.data != right.data)
                return false;
  
             return checkIsSymmetric(left.left,right.right)&& checkIsSymmetric(left.right,right.left);       
        }
      public static    boolean isSymmetric(Node root) {
          return checkIsSymmetric(root.left,root.right);
      }
      public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(3);
        root.right.left = new Node(3);
        root.right.right = new Node(4);
        //root.right.left.left = new Node(7);
        //root.right.left.right = new Node(8);
        System.out.println(isSymmetric(root));
      }
}
