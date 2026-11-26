class Solution {
    public ArrayList<Integer> shortestPath(int V, int[][] edges) {
      
      ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
      ArrayList<Integer> answer = new ArrayList<>();
      boolean[] visited = new boolean[V];
      int[] distance = new int[V];
      Stack<Integer> stack = new Stack<>();
      Arrays.fill(distance,Integer.MAX_VALUE);
      distance[0] = 0;
      
      for(int i=0;i<V;i++){
          adj.add(new ArrayList<>());
      }
        
      for(int [] edge : edges){
        adj.get(edge[0]).add(new int[]{edge[1],edge[2]});     
      }
      
      for(int i=0;i<V;i++){
            if(!visited[i]){
              dfs(i,adj,visited,stack);
          }
      }
      
      while(!stack.isEmpty()){
            
          int u = stack.pop();
            
          if(distance[u] == Integer.MAX_VALUE){
              continue;
          }
            
          for(int[] neighbour : adj.get(u)){
              int v = neighbour[0];
              int w = neighbour[1];
            
              if(distance[u]+w < distance[v]){
                  distance[v] = distance[u]+w;
              }
          }  
      }
      
      for(int d : distance){
              answer.add(d==Integer.MAX_VALUE?-1:d);
        }
      return answer;
    }
    
    private void dfs(int u,ArrayList<ArrayList<int[]>> adj,boolean[] visited,Stack<Integer> stack){
        
        visited[u] = true;
        
        for(int[] neighbour : adj.get(u)){
            
            if(!visited[neighbour[0]]){
                dfs(neighbour[0],adj,visited,stack);
            }
        }
        
        stack.push(u);
    }
}
