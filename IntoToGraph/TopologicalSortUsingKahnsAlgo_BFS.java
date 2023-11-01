package DSA_programs.IntoToGraph;
import java.util.*;
public class TopologicalSortUsingKahnsAlgo_BFS {
    public static List<Integer> topologicalSort(int[][] edges, int e, int v) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>(v);
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        //create a Directed acyclic graph
        for(int i=0;i<e;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        int[] indegree=new int[v];
        //find indegree
        for(ArrayList<Integer> ar:adj){
            for(Integer ele:ar){
                indegree[ele]++;
            }
        }
        List<Integer> l=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<v;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int front=q.remove();
            l.add(front);
            for(int i=0;i<adj.get(front).size();i++){
                int neighBour=adj.get(front).get(i);
                indegree[neighBour]--;
                if(indegree[neighBour]==0){
                    q.add(neighBour);
                }
            }
        }
        return l;
    }
    public static void main(String[] args) {
        int[][] edges={{1,0},{2,0},{3,0}};
        System.out.println(topologicalSort(edges, edges.length, 4));
    }
}
