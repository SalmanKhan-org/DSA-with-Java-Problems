package DSA_programs.IntoToGraph;

import java.util.LinkedList;
import java.util.*;
public class ImplementGraphByAdjacencyList {
    static class Pair{
        int vertex;
        int weight;
        Pair(int vertex,int weight){
            this.vertex=vertex;
            this.weight=weight;
        }
    }
    static class Graph{
        int vertex;
        LinkedList<Integer> graph[];
        Graph(int vertex,int edges){
            this.vertex=vertex;
            graph=new LinkedList[vertex];
            //initialize a new linked list at each index
            for(int i=0;i<vertex;i++){
                graph[i]=new LinkedList<>();
                Queue<Integer> q=new LinkedList<>();
        
            }
        }
        public void adEdge(int source,int destination){
            //for directed graph
            graph[source].addFirst(destination);
            //for undirected graph
            graph[destination].addFirst(source);
        }
        public void printGraph(){
            for(int i=0;i<vertex;i++){
                if(graph[i].size()>0){
                    System.out.print("vertex "+i+" is connected to:");
                }
                for(int j=0;j<graph[i].size();j++){
                    System.out.print(graph[i].get(j)+" ");
                }
                System.out.println();
            }
        }
    }
    public static void consGraphwithWeight(int[][] edges,int V,int E){
        LinkedList<Pair> Graph[]=new  LinkedList[V];
        for(int i=0;i<V;i++){
            Graph[i]=new LinkedList<>();
        }
        //construct graph
        for(int i=0;i<edges.length;i++){
            int source=edges[i][0];
            int dest=edges[i][1];
            int weight=edges[i][2];
            Graph[source].add(new Pair(dest, weight));
            //Graph[dest].add(new Pair(source, weight));
        }
        //printing  the graph
        for(int i=0;i<V;i++){
           // if(Graph[i].size()>0){
                System.out.print("vertex "+i+" is connected to:");
            //}
            for(int j=0;j<Graph[i].size();j++){
                int vertex=Graph[i].get(j).vertex;
                int weight=Graph[i].get(j).weight;
                System.out.print("["+vertex+","+weight+"]");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        // Graph   g=new Graph(5, 5);
        // g.adEdge(0, 1);
        // g.adEdge(0, 4);
        // g.adEdge(1, 2);
        // g.adEdge(1, 3);
        // g.adEdge(1, 4);
        // g.adEdge(2, 3);
        // g.adEdge(3, 4);
        // g.printGraph();
        int[][] edges={{0,1,4},{0,2,5},{1,0,4},{1,2,6},{2,0,5},{2,1,6},{2,3,3},{3,2,3}};
        consGraphwithWeight(edges, 4, edges.length);
    }
}
