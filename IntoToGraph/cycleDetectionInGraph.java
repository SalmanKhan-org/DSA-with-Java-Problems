package DSA_programs.IntoToGraph;
import java.util.*;
public class cycleDetectionInGraph {
    public static boolean isDetectCycle(ArrayList<ArrayList<Integer>> adj,int parent,int node,boolean[] visited)
	{
		visited[node]=true;
         for(int neighBour:adj.get(node)){
            // int neighBour=adj.get(node).get(i);
            if(!visited[neighBour]){
                boolean isCycle=isDetectCycle(adj,node,neighBour,visited);
                if(isCycle){
                    return true;
                }
            }else if(neighBour!=parent){
               return true;
            }
        }
		return false;
	}
    
    public static String cycleDetection(int[][] edges, int n, int m) {
        n++;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        //creating graph from the vertices

        for(int i=0;i<edges.length;i++){
             adj.get(edges[i][0]).add(edges[i][1]);
             adj.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] isVisited=new boolean[n];
        //for disconnected graph
        for(int i=1;i<=n;i++){
            if(!isVisited[i]){
                boolean res=isDetectCycle(adj,-1,i, isVisited);
                if(res==true){
                    return "Yes";
                }
            }
        }
        return "No";
    }
    public static void main(String[] args) {
        int[][] edges={{1,2},{2,3},{1,3}};
        System.out.println(cycleDetection(edges, 3, edges.length));
    }
}
