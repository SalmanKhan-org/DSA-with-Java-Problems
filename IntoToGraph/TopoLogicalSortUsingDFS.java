package DSA_programs.IntoToGraph;
import java.util.*;
import java.util.Stack;
public class TopoLogicalSortUsingDFS {
    public static void DFStopoSort(ArrayList<ArrayList<Integer>> adj,boolean[] isVisited,
    Stack<Integer> st,int node){
        isVisited[node]=true;
        
        for(int i=0;i<adj.get(node).size();i++){
            int neighBour=adj.get(node).get(i);
            if(!isVisited[neighBour]){
                DFStopoSort(adj,isVisited,st,neighBour);
            }
        }
        st.push(node);
    }
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        boolean[] isVisited=new boolean[V];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<V;i++){
            if(!isVisited[i]){
                DFStopoSort(adj,isVisited,st,i);
            }
        }
        int[] topoSort=new int[V];
        for(int i=0;i<V;i++){
            topoSort[i]=st.pop();
        }
        return topoSort;
    }
}
