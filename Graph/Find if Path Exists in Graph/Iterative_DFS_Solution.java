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
        Stack<Integer> recursion = new Stack<>();

        recursion.push(source);

        while(!recursion.isEmpty()){

            int node = recursion.pop();
            visited[node] = true;

            for(int i=0;i<graph.get(node).size();i++){
                int newnode = graph.get(node).get(i);

                if(!visited[newnode]){
                    recursion.push(newnode);
                    visited[newnode] = true;
                }
            }
        }

        return visited[destination];
    }
}
