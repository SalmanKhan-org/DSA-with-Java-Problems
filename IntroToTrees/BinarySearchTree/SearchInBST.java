package DSA_programs.IntroToTrees.BinarySearchTree;

public class SearchInBST {
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
    //Time complexity = O(H) where H is the height of the tree 
    //Auxillary Space =O(n) for recursive stack
    // private static boolean searchKey(Node root,int key){
    //     if(root==null) return false;

    //     if(root.data==key){
    //         return true;
    //     }
    //     if(root.data>key){
    //         return searchKey(root.left, key);
    //     }else{
    //         return searchKey(root.right, key);
    //     }
    // }
    private static boolean searchKey(Node root,int key){
        while(root !=null){
            if(root.data ==key){
                return true;
            }else if(root.data>key){
                root =root.left;
            }else{
                root=root.right;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[]  values  = {8,5,10,11,3,6,1,4,14};
        Node  root = null;
        for(int i=0;i<values.length;i++){
            root  =  insertInBST(root, values[i]);
        }
        System.out.println(searchKey(root,44));
    }
}
