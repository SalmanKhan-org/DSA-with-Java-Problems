package DSA_programs.LaunchHashmap;

import java.util.ArrayList;
import java.util.LinkedList;

public class ImplementHashMap {
    static class HashMap<K,V>{
        private class Node{
            K key;
            V value;
            Node(K key,V value){
                this.key = key;
                this.value = value;
            }
        }
        private int n;//number of nodes
        private int N;//size of HashMap
        private LinkedList<Node> buckets[];
        @SuppressWarnings("Unchecked")
        private HashMap(){
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i=0;i<N;i++){
                buckets[i] = new LinkedList<>();
            }
        } 
        private int hashFunction(K key){
            int bi = key.hashCode();
            return Math.abs(bi)%N;//bi = (0-(n-1))
        }
        private int searchInLinkedList(int bi, K key){
            LinkedList<Node> ll = buckets[bi];
            for(int i=0;i<ll.size();i++){
                if(key == ll.get(i).key){
                    return i;
                }
            }
            return -1;
        }
        @SuppressWarnings("Unchecked")
        private void rehash(){
            LinkedList<Node> oldBuckets[] = buckets;
            buckets = new LinkedList[N*2];
            for(int i=0;i<N*2;i++){
                buckets[i] = new LinkedList<>();
            }
            //for rehash
            for(int i=0;i<oldBuckets.length;i++){
                LinkedList<Node> ll = oldBuckets[i];
                for(int j=0;j<ll.size();j++){
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }
        private void put(K key, V value){
            //find bucket index at which our value will be stored
            int bi = hashFunction(key);
            //find if our key exist in our hashmap or not
            int di = searchInLinkedList(bi,key);
            if(di == -1){
                buckets[bi].add(new Node(key, value));
                n++;
            }else{
                Node node = buckets[bi].get(di);
                node.value = value;
            }
            double lambda = (double)n/N;
            if(lambda>2.0){
                rehash();
            }
        }
        private V get(K key){
             //find bucket index at which our value will be stored
             int bi = hashFunction(key);
             //find if our key exist in our hashmap or not
             int di = searchInLinkedList(bi,key);
             if(di == -1){
                 return null;
             }else{
                 Node node = buckets[bi].get(di);
                 return node.value;
             }
        }
        private boolean containsKey(K key){
             //find bucket index at which our value will be stored
             int bi = hashFunction(key);
             //find if our key exist in our hashmap or not
             int di = searchInLinkedList(bi,key);
             if(di == -1){
                 return false;
             }else{
                return true;
             }
        }
        private V remove(K key){
             //find bucket index at which our value will be stored
             int bi = hashFunction(key);
             //find if our key exist in our hashmap or not
             int di = searchInLinkedList(bi,key);
             if(di == -1){
                return null;
             }else{
                Node node = buckets[bi].remove();
                n--;
                return node.value;
             }
        }
        private ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
            for(int i=0;i<buckets.length;i++){
                LinkedList<Node> ll = buckets[i];
                for(int j=0;j<ll.size();j++){
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }
        private boolean isEmpty(){
            return n==0;
        }
    }
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("India", 190);
        map.put("china", 200);
        map.put("USA", 50);
        map.put("turkey", 30);
        map.put("pakistan", 25);
        ArrayList<String> keys = map.keySet();
        for(int i=0;i<keys.size();i++){
            System.out.println(keys.get(i)+"  "+map.get(keys.get(i)));
        }
    }
}
