package DSA_programs.IntroToTrees.BinaryTree;
class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data =  data;
        left  = right  =  null;
    }
}
//Time complexity=O(n^2)
//space complexity=O(h);
public class Zig_ZagTraversal {
    private static boolean zigZagTraversal(Node root,int lvl,int track){
        if(root==null){
            return true;
        }
        if(lvl==1){
            System.out.print(root.data+" ");
            return true;
        }
        if(track%2==0){
           boolean right=zigZagTraversal(root.right, lvl-1, track);
           boolean left=zigZagTraversal(root.left, lvl-1, track);
           return left||right;
        }
        if(track%2==1){
        boolean left=  zigZagTraversal(root.left, lvl-1, track);
        boolean right=  zigZagTraversal(root.right, lvl-1,track);
        return left||right;
        }
        return true;
    }
    private static void spiralTraversal(Node root){
        int lvl=1,track=1;
        while(zigZagTraversal(root,lvl,track)){
            lvl++;
            track++;
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
        spiralTraversal(root);

    }
}
