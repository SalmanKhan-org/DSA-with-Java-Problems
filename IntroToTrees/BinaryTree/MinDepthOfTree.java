package DSA_programs.IntroToTrees.BinaryTree;
class Node{
    int data;
    Node left,right;
    public Node(int data){
        this.data=data;
        left=right=null;
    }
}
public class MinDepthOfTree {
    private static int minDepth(Node root){
        //if root node is null  means there is no depth
        if(root==null)  return 0;
        //if left and right subtree of root node are null  then only depth of root node will be there which is 1
        if(root.left==null&&root.right==null){
            return 1;
        }
        //if left subTree of  a root is null then depth will be on right side
        if(root.left==null)  return 1+minDepth(root.right);
        //if right SubTree of a root is null then depth will  be on left side
        if(root.right==null) return 1+minDepth(root.left);
        //if both the SubTree of root node are  not  null then find the depth on both side
        return 1+Math.min(minDepth(root.left),minDepth(root.right));
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        //root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
        System.out.println("The minTree of this binary tree is:"+minDepth(root));
    }
}
