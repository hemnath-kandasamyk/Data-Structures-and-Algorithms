// Shortest Path in Directed Acyclic Graph
class Solution {
    public ArrayList<Integer> shortestPath(int V, int[][] edges) {
        
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        
        int[] indegree = new int[V];
        result.add(0);
        
        for(int i=1;i<V;i++){
            result.add(-1);
        }
    
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            graph.get(edge[0]).add(new int[]{edge[1],edge[2]});
            indegree[edge[1]]++;
        }
        
        for(int i=0;i<V;i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        
        while(!queue.isEmpty()){
            
            int node = queue.poll();
            
            for(int i=0;i<graph.get(node).size();i++){
                
                int[] curr = graph.get(node).get(i);
                
                int v = curr[0];
                int wt = curr[1];
                
                indegree[v]--;
                
                if(result.get(node) != -1){
                    
                    int newdistance = result.get(node) +wt;

                    if(result.get(v) == -1 || newdistance < result.get(v)){
                        result.set(v,newdistance);
                    }
                }
                
                if(indegree[v] == 0){
                    queue.offer(v);
                }
                
            }
        }
        return result;
    }
}
