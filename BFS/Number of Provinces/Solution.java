class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[] visited=new boolean[n];
        int provinces=0;
        
        for(int i=0;i<n;i++){
            if(visited[i]){
                continue;
            }
            provinces++;
            Queue<Integer> queue=new LinkedList<>();
            queue.add(i);
            visited[i]=true;
            
            while(!queue.isEmpty()){
                int curr=queue.poll();
                for(int j=0;j<n;j++){
                    boolean node=isConnected[curr][j]==1;
                    if(!visited[j] && node){
                        visited[j]=true;
                        queue.add(j);
                    }
                }
            }
        }
        return provinces;
    }
}
