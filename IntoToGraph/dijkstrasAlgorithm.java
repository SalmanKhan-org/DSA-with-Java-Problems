package DSA_programs.IntoToGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class dijkstrasAlgorithm {
    static class Pair implements Comparable<Pair>{
        int first;
        int second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
        @Override
        public int compareTo(Pair o) {
           return this.second-o.second;
        }
    }
    public  static int[] dijkstras(int[][] edges,int  V,int E,int src){
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
        int dis[]=new int[V];
        Arrays.fill(dis, Integer.MAX_VALUE);
        Queue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(src,0));
        dis[src]=0;
        while(!pq.isEmpty()){
            int min=pq.poll().first;
            for(Pair p:adj.get(min)){
                if(dis[min]+p.second<dis[p.first]){
                    dis[p.first]=dis[min]+p.second;
                    pq.add(new Pair(p.first, dis[p.first]));
                }
            }
        }
        return  dis;
    }
    public static void main(String[] args) {
        int[][] edges={{0, 1, 5},
            {0 ,2 ,8},
            {1, 0, 5},
            {1, 2, 9},
            {1 ,3 ,2 },
            {2, 0, 8},
            {2 ,1 ,9},
            {2 ,3 ,6},
            {3 ,2 ,6},
            {3 ,1 ,2}};
            int  ans[]=dijkstras(edges, 4, edges.length, 0);
            System.out.println(Arrays.toString(ans));
    }
}
