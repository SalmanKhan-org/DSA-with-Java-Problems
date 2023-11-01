package DSA_programs.IntoToGraph;

public class InplementUsingAdjacencyMatrix {
    static class Graph{
        int vertex;
        int edges;
        int[][] graph;
        Graph(int vertex,int edges){
            this.vertex=vertex;
            this.edges=edges;
            graph=new int[vertex][edges];
        }
        public void adEdge(int source,int destination){
            //for directed graph
            graph[source][destination] =1;
            //for unidirected graph
            //graph[destination][source]=1;
        } 
        public void printGraph(){
            for(int i=0;i<vertex;i++){
                for(int j=0;j<edges;j++){
                    System.out.print(graph[i][j]+" ");
                }
                System.out.println();
            }
            for(int i=0;i<vertex;i++){
                System.out.print("vetex "+i+" is connected to:");
                for(int j=0;j<vertex;j++){
                    if(graph[i][j]!=0){
                        System.out.print(j+" ");
                    }
                }
                System.out.println();
            }
        }
    }
    public static void consUndirectedWeightedGraph(int[][] edges,int V,int E){
        int[][] Graph=new int[V+1][V+1];
        //construct graph
        for(int i=0;i<edges.length;i++){
            int source=edges[i][0];
            int dest=edges[i][1];
            int weight=edges[i][2];
            Graph[source][dest]=weight;
        }
        //printGraph
        System.out.println("The graph is:");
        for(int i=0;i<=V;i++){
            for(int j=0;j<=V;j++){
                System.out.print(Graph[i][j]+" ");
            }
            System.out.println();
        }
        for(int i=0;i<=V;i++){
            System.out.print("vertex "+i+" connected with:");
            for(int j=0;j<=V;j++){
                if(Graph[i][j]!=0)
                System.out.print("["+j+","+Graph[i][j]+"]");
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
        consUndirectedWeightedGraph(edges, 3, edges.length);
    }
}
