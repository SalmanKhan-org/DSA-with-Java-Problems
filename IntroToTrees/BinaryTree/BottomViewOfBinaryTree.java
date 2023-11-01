package DSA_programs.IntroToTrees.BinaryTree;
import java.util.*;
class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data =  data;
        left  = right  =  null;
    }
}
class BottomViewOfBinaryTree
{
    static void bottomView(Node root)
    {
        class Pair{
        Node node;
        int hd;
        Pair(Node node,int num){
            this.node = node;
            this.hd= num;
        }
    }
        Map<Integer,Integer> m = new HashMap<>();
        ArrayList<Integer> ar = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        int min=0;
        int max=0;
        if(root==null) return ;
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            Pair p  =  q.poll();
            Node frontNode = p.node;
            int hd = p.hd;
            m.put(hd,frontNode.data);
            if(frontNode.left!=null){ 
                min =Math.min(min,hd-1);
                q.add(new Pair(frontNode.left,hd-1));
            }
            if(frontNode.right!=null){
                max = Math.max(max,hd+1);
                q.add(new Pair(frontNode.right,hd+1));
            }
        }
        for(;min<=max;min++){
            System.out.print(m.get(min)+" ");
        }
        // for(int key :m.keySet()){
        //     System.out.print(m.get(key)+" ");
        // }
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
        bottomView(root);
    }
}
