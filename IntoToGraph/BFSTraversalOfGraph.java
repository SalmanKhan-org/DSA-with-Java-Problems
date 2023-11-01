package DSA_programs.IntoToGraph;
import java.util.*;
public class BFSTraversalOfGraph {
    private static  List<Integer> BFSTraversal(LinkedList<Integer> graph[],int v,int node){
        Queue<Integer> q=new LinkedList<>();
        List<Integer> l=new LinkedList<>();
        boolean  visited[] = new boolean[v];
        q.add(node);
        visited[node]=true;
        while(!q.isEmpty()){
            int n=q.remove();
            l.add(n);
            Iterator<Integer>   itr=graph[n].listIterator();
            while(itr.hasNext()){
                int frontNode=itr.next();
                q.add(frontNode);
                visited[frontNode]=true;
            }
        }
        return l;
    }
    private static List<Integer> BFSofGraph(int vertex,int[][] edges){
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

            return BFSTraversal(graph,vertex,0);
    }
    public static void main(String[] args) {
        int[][] edges={{0, 1},
                              {0, 2},
                             {0, 3},
                            {1, 4},
                             {1, 7},
                              {2, 5},
                            {3, 6}};
         System.out.println(BFSofGraph(8, edges)); 
    }
}
