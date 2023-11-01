package DSA_programs.IntoToGraph;

public class KrusKalAlgorithmForMinSpanningTree {
    private static void makeSet(int[] parent,int[] rank,int n){
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }
    }
    private static int findparent(int[] parent,int node){
        if(parent[node]==node){
            return node;
        }
        return parent[node]=findparent(parent,parent[node]);
    }
    //union set
    private static void unionSet(int u,int v,int parent[],int[] rank){
        //find parent of u and v
        u=findparent(parent, u);
        v=findparent(parent, v);
        //if rank of both the parents are  equal
        if(rank[u]<rank[v]){
            parent[u]=v;
        }else if(rank[u]>rank[v]){
            parent[v]=u;
        }else{
            parent[v]=u;
            rank[u]++;
        }
    }
    private static void kruskalAlgo(int[][] edges,int n){
        int[] parent=new int[n];
        int[] rank=new  int[n];
        makeSet(parent,rank,n);
    }
    public static void main(String[] args){

    }
}
