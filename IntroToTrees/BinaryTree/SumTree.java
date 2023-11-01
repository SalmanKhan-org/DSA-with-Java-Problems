package DSA_programs.IntroToTrees.BinaryTree;
class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data =  data;
        left  = right  =  null;
    }
}
class pairs<Boolean ,Integer>{
    Boolean  first;
    int second;
    pairs(Boolean first,int second){
        this.first=first;
        this.second=second;
    }
}
public class SumTree {
     private static pairs<Boolean,Integer> checkSumTree(Node root){
        //base  case
        if(root==null)  {
            pairs<Boolean,Integer> p = new pairs(true,0);
            return p;
        }

        if(root.left==null&&root.right==null){
            pairs<Boolean,Integer> p = new pairs(true, root.data);
            return p;
        }
        // if(root.left==null||root.right==null){
        //     pair<Boolean,Integer> p1 =  new pair(true, 0);
        // }
        pairs<Boolean,Integer> left =  checkSumTree(root.left);
        pairs<Boolean,Integer> right =  checkSumTree(root.right);
        int leftAns  = left.second;
        int rightAns = right.second;
        boolean sum =( root.data  == leftAns+rightAns);
        pairs<Boolean,Integer> ans    = new pairs(true, 0); 
        if(left.first&&right.first&&sum){
            ans.first =true;
            ans.second = root.data  + leftAns+rightAns;
        }else{
            ans.first =false;
        }
        return ans;
     }
    private static  boolean isSumTree(Node root){
        
        return checkSumTree(root).first;
    }
    // private static boolean isSumTree(Node root){
    //     if(root.left==null && root.right==null) return true;
    //     if(root.left==null ||root.right!=null)  return false;
    //     boolean left  = isSumTree(root.left);
    //     boolean right  = isSumTree(root.right);

    //     boolean value = (root.data == root.left.data+root.right.data);

    //     if(left&& right&&value) return true;
    //     else{
    //         return false;
    //     }
    // }
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left  = new Node(5);
        root.left.left =new Node(3);
        root.left.right=new Node(2);
        root.right  = new  Node(5);
        root.right.left= new Node(5);

        System.out.println(isSumTree(root));
    }
}
