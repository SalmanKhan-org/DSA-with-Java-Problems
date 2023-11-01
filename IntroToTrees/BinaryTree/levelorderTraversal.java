package DSA_programs.IntroToTrees.BinaryTree;
class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data =  data;
        left=right=null;
    }
}
public class levelorderTraversal {
    private static boolean printLevel(Node root, int level){
        if(root==null){
            return false;
        }
        if(level==1){
            System.out.print(root.data+" ");
            return true;
        }
        boolean left  = printLevel(root.left, level-1);
        boolean right=printLevel(root.right, level-1);
        
        return (left||right);
    }
    public static  void levelOrder(Node root){
        int level=1;
        while(printLevel(root,level)){
            level++;
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
        levelOrder(root);
    }
}
