package DSA_programs.IntroToTrees.BinaryTree;

class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data =  data;
        left  = right  =  null;
    }
}
public class DiameterOfTree {
        static int max=0;
        public static int  diameterOfBinaryTree(Node root) {
            height(root);
            return max;
        }
        public static int height(Node root){
            if(root==null) return 0;
    
            int left=height(root.left);
            int right=height(root.right);
    
            max = Math.max(max,left+right);
    
            return 1+Math.max(left,right);
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
            System.out.println("The diamter of the given tree:"+diameterOfBinaryTree(root));
        }
}
