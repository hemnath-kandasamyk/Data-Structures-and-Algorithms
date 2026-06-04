//547. Number of Provinces
class Solution {
    boolean[] visited;
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        visited=new boolean[n];

        int provinces=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                provinces++;
                dfs(isConnected,i);
            }
        }
        return provinces;
    }
    public void dfs(int[][] graph,int node){
         visited[node]=true;
         for(int i=0;i<graph[node].length;i++){
            if(graph[node][i]!=0 &&  !visited[i]){
                dfs(graph,i);
            }
         }
    }
}
