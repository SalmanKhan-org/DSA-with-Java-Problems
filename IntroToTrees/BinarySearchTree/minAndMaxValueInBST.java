package DSA_programs.IntroToTrees.BinarySearchTree;

public class minAndMaxValueInBST {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data =  data;
            left = right =  null;
        }
    }
    public static Node insertInBST(Node root,int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data>val){
            root.left =  insertInBST(root.left, val);
        }else{
            root.right =  insertInBST(root.right, val);
        }
        return root;
    }
    private static Node minValue(Node root){
        if(root==null) return null;

        while(root.left !=null){
            root  = root.left;
        }
        return root;
    }
    private static Node maxValue(Node root){
        if(root==null) return null;
        while(root.right !=null){
            root=root.right;
        }
        return root;
    }

    public static void main(String[] args) {
        int[]  values  = {5,1,3,2,4,7};
        Node  root = null;
        for(int i=0;i<values.length;i++){
            root  =  insertInBST(root, values[i]);
        }
        System.out.println("The minimum value in BST is:"+minValue(root).data);
        System.out.println("The maximum value in BST is:"+maxValue(root).data);
    }
}
