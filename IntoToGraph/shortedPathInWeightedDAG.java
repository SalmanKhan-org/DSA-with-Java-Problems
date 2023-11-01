package DSA_programs.IntoToGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.*;
 class Pair{
     int vertex;
     int weight;
    Pair(int vertex,int weight){
        this.vertex=vertex;
        this.weight=weight;
    }
}
public class shortedPathInWeightedDAG{
    public static void DFStopoSort(ArrayList<ArrayList<Pair>> adj,boolean[] isVisited,
    Stack<Integer> stack,int node){
        isVisited[node]=true;
        
        for(int i=0;i<adj.get(node).size();i++){
            Pair p=adj.get(node).get(i);
            if(!isVisited[p.vertex]){
                DFStopoSort(adj,isVisited,stack,p.vertex);
            }
        }
        stack.push(node);
    }
    public static int[] shortestPath(int[][] edges,int V,int E){
       ArrayList<ArrayList<Pair>> adj=new ArrayList<ArrayList<Pair>>();
        for(int i=0;i<V;i++){
           adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            Pair p=new Pair(edges[i][1], edges[i][2]);
            adj.get(edges[i][0]).add(p);
        }
        boolean visited[]  =new boolean[V];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<V;i++){
            if(!visited[i]){
                DFStopoSort(adj,visited, st,i);
            }
        }

        //find shortest distance path
        int src=0;
        int dis[]=new int[V];
        for(int i=0;i<V;i++){
            dis[i]=Integer.MAX_VALUE;
        }
        dis[src]=0;
        while(!st.empty()){
            int top=st.pop();
            if(dis[top]!=Integer.MAX_VALUE){
                for(int i=0;i<adj.get(top).size();i++){
                   Pair p=adj.get(top).get(i);
                   
                    if(dis[top]+p.weight<dis[p.vertex]){
                        dis[p.vertex]=dis[top]+p.weight;
                    }
                }
            }
        }
        for(int i=0;i<V;i++){
            if(dis[i]==Integer.MAX_VALUE){
                dis[i]=-1;
            }
        }
        return dis;
    }
    public static void main(String[] args) {
        int[][] edges={{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
        int[]  dis=shortestPath(edges, 6, edges.length);
        System.out.println(Arrays.toString(dis));
    }
}
