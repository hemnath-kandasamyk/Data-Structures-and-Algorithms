//2368. Reachable Nodes With Restrictions
class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        
        List<List<Integer>> graph =new ArrayList<>();
        
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int v=edge[0];
            int u=edge[1];

            graph.get(v).add(u);
            graph.get(u).add(v);
        }

        boolean[] visited=new boolean[n];

        for(int i:restricted){
            visited[i]=true;
        }

        Queue<Integer> queue= new LinkedList<>();
        queue.add(0);
        int count=1;
        visited[0]=true;

        while(!queue.isEmpty()){

            int curr=queue.poll();
            
            for(int i=0;i<graph.get(curr).size();i++){
                int node =graph.get(curr).get(i);

                if(!visited[node]){
                    visited[node]=true;
                    count++;
                    queue.add(node);
                }
            }
        }

        return count;
    }
}
