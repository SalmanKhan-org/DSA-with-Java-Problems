package DSA_programs.IntroToTrees.BinaryTree;
class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data =  data;
        left  = right  =  null;
    }
}
class Node1{
    int data;
    Node1 left,right;
    Node1(int data){
        this.data =  data;
        left  = right  =  null;
    }
}
public class IdenticalTrees {
    public  static  boolean isIdentical(Node root1,Node1 root2){
        if(root1==null&& root2==null) return true;

        if(root1== null && root2 !=null) return false;

        if(root1!=null && root2==null) return false;

        boolean  left = isIdentical(root1.left, root2.left);
        boolean right =  isIdentical(root1 .right , root2.right);

        boolean value = root1.data== root2.data;

        if(left &&  right && value) return true;
        else{
            return  false;
        } 
    }
    public static void main(String[] args) {
        Node  root1  =   new  Node(1);
        root1.left   =  new Node(2);
        root1.right  =  new Node(3);
        root1.left .right =  new Node(4);
        Node1 root2  =new Node1(1);
        root2.left   =  new Node1(2);
        root2.right  =  new Node1(3);
        root2.left .right =  new Node1(4);
        System.out.println(isIdentical(root1, root2));
    }
}
