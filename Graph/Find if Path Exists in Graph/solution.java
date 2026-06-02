//1971. Find if Path Exists in Graph
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        if(source==destination){
            return true;
        }

        List<List<Integer>> graph =new ArrayList<>();

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges){
            int v=edge[0];
            int u=edge[1];

            graph.get(v).add(u);
            graph.get(u).add(v);

        }

        boolean[] visited=new boolean[n];
        Queue<Integer> queue=new LinkedList<>();
        queue.add(source);
        visited[source]=true;

        while(!queue.isEmpty()){
            int curr=queue.poll();
            for(int i=0;i<graph.get(curr).size();i++){
                int node=graph.get(curr).get(i);

                if(node==destination){
                    return true;
                }
                if(!visited[node]){
                    visited[node]=true;
                    queue.add(node);
                }
            }
        }
        return false;
    }
}
