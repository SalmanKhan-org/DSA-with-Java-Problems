package DSA_programs.IntroToTrees.BinaryTree;

class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data =  data;
        left  = right  =  null;
    }
}
 class pair<Boolean,Integer>{
    Boolean firsts;
    Integer seconds;
    pair(Boolean firsts, Integer seconds){
        this.firsts =  firsts;
        this.seconds =seconds;
    }
 }
public class checkForBalancedTree {
    static pair<Boolean,Integer> isBalancedFast(Node root){
        if(root==null) {
            pair<Boolean,Integer> p  = new pair(true, 0);
            return p;
        }
        pair<Boolean,Integer> left = isBalancedFast(root.left);
        pair<Boolean,Integer> right = isBalancedFast(root.right);
        Boolean leftAns = left.firsts;
        Boolean rightAns =  right.firsts;

        Boolean diff = Math.abs(left.seconds-right.seconds)<=1;
        pair<Boolean,Integer> ans =  new pair(true, 0);
        ans.seconds  = 1+Math.max(left.seconds,right.seconds);
        if(leftAns && rightAns&&diff){
            ans.firsts =true;
        }else{
            ans.firsts= false;
        }
        return  ans;
    }
    // private static int isBalance(Node root){
    //     //base case
    //     if(root==null)  return 0;
    //     //find  height  of the left SubTree
    //     int left =  isBalance(root.left);
    //     //find height of the right Subtree
    //     int right =  isBalance(root.right);
    //     //check for balance
    //     if(Math.abs(left-right)>1) return -1;

    //     return  1+Math.max(left,right);
    // }
    public static boolean isBalancedTree(Node root){
        // int ans = isBalance(root);
        // if(ans==-1){
        //     return  false;
        // }else{
        //     return true;
        // }
        return isBalancedFast(root).firsts;

    }
    public static void main(String[] args) {
        Node root = new  Node(1);
        root.left = new Node(10);
        root.right =  new Node(39);
        root.left.left = new Node(5);
        System.out.println("The given tree is balance:"+isBalancedTree(root));
    }
}
