package DSA_programs.IntroToTrees.BinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data =  data;
        left  = right  =  null;
    }
}
public class TopViewOfBinaryTree {
    public static List<Integer> topViewtree(Node root){
        class Pair{
            Node node;
            int num;
            Pair(Node node,int num){
                this.node = node;
                this.num = num;
            }
        }
        List<Integer> l  = new LinkedList<>();
        if(root==null)  return l;
        Map<Integer,Integer> m = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair p  = q.poll();
            Node frontNode = p.node;
            int hd =  p.num;
            if(!m.containsKey(hd)){
                m.put(hd, frontNode.data);
            }
            if(frontNode.left!=null) q.add(new Pair(frontNode.left, hd-1));
            if(frontNode.right!=null) q.add(new Pair(frontNode.right, hd+1));
        }
        for(int key:m.keySet()){
            l.add(m.get(key));
        }
        return l;
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
        List<Integer> l = TopViewOfBinaryTree.topViewtree(root);
        for(int a:l){
            System.out.print(a+" ");
        }
    }
}
