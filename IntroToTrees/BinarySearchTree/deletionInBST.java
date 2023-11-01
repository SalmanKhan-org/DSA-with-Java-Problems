package DSA_programs.IntroToTrees.BinarySearchTree;

public class deletionInBST {
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
        public static void inorderTraversal(Node root){
            if(root==null) return;
    
            inorderTraversal(root.left);
            System.out.print(root.data+" ");
            inorderTraversal(root.right);
        }
        public static Node delete(Node root,int val){
            if(root==null) return null;
            if(root.data>val){
               root.left =  delete(root.left, val);
            }else if(root.data<val){
                root.right=delete(root.right, val);
            }else{
                if(root.left==null && root.right==null){
                    return  null;
                }
                if(root.left==null){
                    return root.right;
                }else if(root.right==null){
                    return root.left;
                }
                Node IS =inorderSuccesor(root.left);
                root.data = IS.data;
                root.left=delete(root.left, IS.data);
            }
            return root;
        }
        private static Node inorderSuccesor(Node root) {
            while(root.right!=null){
                root = root.right;
            }
            return root;
        }
        public static void main(String[] args) {
            int[]  values  = {8,5,10,11,14,3,6,4,1};
            Node  root = null;
            for(int i=0;i<values.length;i++){
                root  =  insertInBST(root, values[i]);
            }
            System.out.println("Before deletion of the element:");
            inorderTraversal(root);
            System.out.println("\nAfter deletion of the given element:");
            Node node = delete(root, 5      );
            inorderTraversal(node);
    }
}
