package DSA_programs.IntoToGraph;
import java.util.*;
public class cycleDetectionInDirectedGraphDFS {
    public boolean cycleDetected(ArrayList<ArrayList<Integer>> adj,int node,boolean[] isVisited
    ,boolean[] dfsCall){
        isVisited[node]=true;
        dfsCall[node]=true;
        
        for(int i=0;i<adj.get(node).size();i++){
            int neighBour=adj.get(node).get(i);
            if(!isVisited[neighBour]){
                boolean cycleFound=cycleDetected(adj,neighBour,isVisited,dfsCall);
                if(cycleFound){
                    return true;
                }
            }else if(dfsCall[neighBour]==true){
                return true;
            }
        }
        dfsCall[node]=false;
        return false;
    }
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] isVisited=new boolean[V];
        boolean[] dfsCall=new boolean[V];
        for(int i=0;i<V;i++){
            if(!isVisited[i]){
                if(cycleDetected(adj,i,isVisited,dfsCall)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        
    }
}
