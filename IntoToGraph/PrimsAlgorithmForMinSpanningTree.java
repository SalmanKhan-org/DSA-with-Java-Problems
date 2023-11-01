package DSA_programs.IntoToGraph;
import java.util.*;
public class PrimsAlgorithmForMinSpanningTree {
    static class Pair implements Comparable<Pair>{
        int vertex;
        int weight;
        Pair(int first,int second){
            this.vertex=first;
            this.weight=second;
        }
        @Override
        public int compareTo(Pair o) {
           return this.weight-o.weight;
        }
    }
    public  static int spanningTree(int  V,int E,int[][] edges){
        ArrayList<ArrayList<Pair>> adj=new ArrayList<ArrayList<Pair>>();
        //assign a new arrayList At each index of adj
        for(int  i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        //create a ArrayList
        for(int i=0;i<E;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }
        int key[]=new int[V];
        int[] parent=new int[V];
        boolean[] mst=new boolean[V];
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        Queue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(0,0));
        key[0]=0;
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int vertex=p.vertex;
            mst[vertex]=true;
            for(int i=0;i<adj.get(vertex).size();i++){
               Pair n=adj.get(vertex).get(i);
               int vVertex=n.vertex;
               int weight=n.weight;
               if(mst[vVertex]==false&&weight<key[vVertex]){
                key[vVertex]=weight;
                parent[vVertex]=vertex;
                pq.add(new Pair(vVertex, key[vVertex]));
               }
            }
        }
        int s=0;
        for(int i=0;i<V;i++){
            s+=key[i];
        }
        return s;
	}
    public static void main(String[] args) {
        int[][] edges={{0,3,6},{0,1,2},{1,0,2},{1,3,8},{1,2,3},{1,4,5},{2,1,3},{2,4,7},{3,0,6},{3,1,8},{4,1,5},{4,2,7}};
        System.out.println(spanningTree(5, edges.length, edges));
    }
}
