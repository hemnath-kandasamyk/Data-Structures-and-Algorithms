//802. Find Eventual Safe States
class Solution {

    int[] state;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        state =new int[n];
        List<Integer> list= new ArrayList<>();
        for (int i=0;i<n;i++){
            if(dfs(i,graph)){
                list.add(i);
            }
        }
        return list;
    }
    public boolean dfs(int node,int[][] graph){
       if(state[node]==1){
        return false;
       }
       if(state[node]==2){
        return true;
       }
       state[node]=1;
       for(int next : graph[node]){
          if(!dfs(next,graph)){
            return false;
          }
       }
       state[node]=2;
       return true;
    }
}
