// 1971. Find if Path Exists in Graph
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int v = edge[0];
            int u = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        dfs(graph,source,visited);

        return visited[destination];
    }

    public void dfs(ArrayList<ArrayList<Integer>> graph,int node,boolean[] visited){

        visited[node] = true;

        for(int i=0;i<graph.get(node).size();i++){

            int newnode = graph.get(node).get(i);
            
            if(!visited[newnode]){
                dfs(graph,newnode,visited);
            }
        }
    }
}
