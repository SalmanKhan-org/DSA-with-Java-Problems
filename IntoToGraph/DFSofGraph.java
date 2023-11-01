package DSA_programs.IntoToGraph;
import java.util.*;
public class DFSofGraph {
    private static void DFS(LinkedList<Integer> graph[],ArrayList<Integer> ans,
    boolean[] isVisited,int node){
        ans.add(node);
        isVisited[node]=true;
        
        Iterator<Integer> itr=graph[node].listIterator();
        while(itr.hasNext()){
            int n=itr.next();
            if(!isVisited[n]){
                DFS(graph,ans,isVisited,n);
            }
        }
    }
    private static List<Integer> DFSofGraph(int vertex,int[][] edges){
        LinkedList<Integer> graph[];
        graph=new LinkedList[vertex];
        //initialize a new linked list at each index
        for(int i=0;i<vertex;i++){
            graph[i]=new LinkedList<>();
        }
        //creating a graph
        for(int i=0;i<edges.length;i++){
            int source=edges[i][0];
            int destination=edges[i][1];
            graph[source].add(destination);
        }
        ArrayList<Integer> ans=new ArrayList<>();
        boolean[] isVisited=new boolean[vertex];
        DFS(graph,ans,isVisited,0);
        return ans;
    }
    public static void main(String[] args) {
        int[][] edges={{0, 1},
                              {0, 2},
                             {0, 3},
                            {1, 0},
                             {4, 2},
                              {2, 0},
                              {2, 4},
                            {3, 0}};
         System.out.println(DFSofGraph(5, edges)); 
    }
}
