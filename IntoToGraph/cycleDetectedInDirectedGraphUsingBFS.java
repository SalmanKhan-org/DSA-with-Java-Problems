package DSA_programs.IntoToGraph;
import java.util.*;
public class cycleDetectedInDirectedGraphUsingBFS {
    public static Boolean isCyclic(int[][] edges, int v, int e){
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
       int  cnt=0;
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<v;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int front=q.remove();
            cnt++;
            for(int i=0;i<adj.get(front).size();i++){
                int neighBour=adj.get(front).get(i);
                indegree[neighBour]--;
                if(indegree[neighBour]==0){
                    q.add(neighBour);
                }
            }
        }
        if(cnt==v){
            return false;
        }else{
            return true;
        }
    }
    public static void main(String[] args) {
        int[][] edges={{0 ,1},
            {1 ,2},
            {2 ,3},
            {3, 0}};

        System.out.println(isCyclic(edges, 4, edges.length));
    }
}
