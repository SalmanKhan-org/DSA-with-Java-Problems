package DSA_programs.IntoToGraph;
import java.util.*;
 class shotestPathInUnweightedUndirectedGraph{
    public static LinkedList<Integer> shortestPath(int[][] edges, int n, int m, int s, int t) {
		ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        //create a undirected graph
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        Queue<Integer> q=new LinkedList<>();
        int[] parent=new int[n];
        boolean[] visited=new boolean[n];
		visited[s]=true;
        q.add(s);
		parent[s]=-1;
		//do bfs
		while(!q.isEmpty()){
			int  front=q.poll();
			for(int i=0;i<adj.get(front).size();i++){
				int neighBour=adj.get(front).get(i);
				if(!visited[neighBour]){
					q.add(neighBour);
					visited[neighBour]=true;
					parent[neighBour]=front;
				}
			}
		}
		LinkedList<Integer> ans=new LinkedList<>();
		//extract the shortest path from the parent array
		int curNode=t;
		ans.add(curNode);
		while(curNode!=s){
			curNode=parent[curNode];
			ans.add(curNode);
		}
		Collections.reverse(ans);
		return ans;
	}
    public static void main(String[] args) {
        int[][] edges={{1 ,2},
                              {2, 3},
                              {3, 4},
                             {1, 3}};
        System.out.println(shortestPath(edges, 5, 4, 1, 4));
    }
}