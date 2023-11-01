package DSA_programs.IntroToTrees.BinaryTree;

public class BuildBinaryTree {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right = null;
        }
    }
    static class BinaryTree{
        static int idx=-1;
        public  Node BuildBinaryTrees(int[] nodes){
            idx++;
            if(idx==nodes.length) return null;
            //base case
            if(nodes[idx]==-1) return null;

            Node newNode = new Node(nodes[idx]);
            newNode.left = BuildBinaryTrees(nodes);
            newNode.right=BuildBinaryTrees(nodes);

            return newNode;
        }
    }
    //preOrder traversal in the binary tree
    public  static void  preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void inorder(Node root){
        if(root==null) return;

        inorder(root.left);
        System.out.print(root.data);
        inorder(root.right);
    }
    public static void postorder(Node root){
        if(root==null)  return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data);
    }
    public static void main(String[] args) {
        int[] nodes ={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1};
        BinaryTree  tree = new BinaryTree();
        Node root = tree.BuildBinaryTrees(nodes);
        System.out.println("preorder traversal:");
        preorder(root);
        System.out.println("\nInOrder traversal:");
        inorder(root);
        System.out.println("\nPostOrder traversal:");
        postorder(root);
    }
}
