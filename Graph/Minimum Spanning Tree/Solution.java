// Minimum Spanning Tree
// Prims Algorithm 
class Solution {
    public int primMST(ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[0],b[0])
            );
        int n = adj.size();
        boolean[] visited = new boolean[n];
        int sum = 0;
            
        pq.offer(new int[]{0,0});
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            
            int node = curr[1];
            int wt = curr[0];
            
            if(visited[node]){
                continue;
            }
            sum = sum + wt;
            visited[node] = true;
            
            for(int i=0;i<adj.get(node).size();i++){
                
                int edgewt = adj.get(node).get(i).get(1);
                int adjnode = adj.get(node).get(i).get(0);
                
                if(!visited[adjnode]){
                    pq.offer(new int[]{edgewt,adjnode});
                }
            }
        }
            
        return sum;
    }
}
