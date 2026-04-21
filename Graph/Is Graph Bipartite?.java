class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] flag=new int[n];
        for(int idx=0;idx<n;idx++){
         if(flag[idx]!=0){
            continue;
         }   
        flag[idx]=1;
        Queue<Integer> q=new LinkedList<>();
        q.add(idx);
        while(!q.isEmpty()){
            int temp=q.poll();
            for(int i=0;i<graph[temp].length;i++){
                if(flag[graph[temp][i]]==0){
                    q.add(graph[temp][i]);
                    flag[graph[temp][i]]=-flag[temp];
                }
                else if(flag[graph[temp][i]]==flag[temp]){
                    return false;
                }
            }
        }
        }
        return true;
    }
}
