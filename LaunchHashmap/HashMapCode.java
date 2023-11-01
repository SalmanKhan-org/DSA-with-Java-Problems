package DSA_programs.LaunchHashmap;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapCode{
    static class HashMaps<K,V>{
        private class Node{
            K key;
            V value;

            public Node(K key, V value){
                this.key =key;
                this.value = value;
            }
        }
            private int n;//number of nodes
            private int N;//number of buckets
            private LinkedList<Node> buckets[];
        @SuppressWarnings("Unchecked")
        public HashMaps() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i=0;i<N;i++){
                this.buckets[i] = new LinkedList<>();
            }
        }
        private int hashFunction(K key){//bi = 0-(n-1)
            int bi = key.hashCode();
            return Math.abs(bi)%N;
        }
        private int searchInLL(K key,int bi){
            LinkedList<Node> ll = buckets[bi];
            for(int i=0;i<ll.size();i++){
                if(ll.get(i).key == key){
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
            for(int i=0;i<oldBuckets.length;i++){
                LinkedList<Node> ll = oldBuckets[i];
                for(int j=0;j<ll.size();i++){
                    Node node = ll.get(j);
                    put(node.key,node.value);
                }
            }
        }
        public void put(K key,V value){
            int bi = hashFunction(key);
            int di = searchInLL(key,bi);//data index=-1

            if(di==-1){//key doesn't exist
                buckets[bi].add(new Node(key,value));
                n++;
            }else{//key exist
                Node data = buckets[bi].get(di);
                data.value = value;
            }
            double lambda= (double)n/N;
            if(lambda>2.0){
                //rehashing
                rehash();
            }
        }
        public V get(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key,bi);//data index=-1

            if(di==-1){//key doesn't exist
               return null;
            }else{//key exist
                Node data = buckets[bi].get(di);
                return data.value;
            }
        }
        public boolean containsKey(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key,bi);//data index=-1

            if(di==-1){//key doesn't exist
               return false;
            }else{//key exist
                return true;
            }
        }
        public V remove(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key,bi);//data index=-1

            if(di==-1){//key doesn't exist
               return null;
            }else{//key exist
                Node data = buckets[bi].remove();
                n--;
                return data.value;
            }
        }
        public ArrayList<K> keySet(){
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
        public boolean isEmpty(){
            return n==0;
        }
    }

    public static void main(String[] args) {
        HashMaps<String,Integer> map = new HashMaps<>();
        map.put("India", 190);
        map.put("china", 200);
        map.put("USA", 50);
        map.put("turkey", 30);
        map.put("pakistan", 25);
        //System.out.println(map);
        ArrayList<String> keys = map.keySet();
        for(int i=0;i<keys.size();i++){
            System.out.println(keys.get(i)+" "+map.get(keys.get(i)));
        }
    }
}