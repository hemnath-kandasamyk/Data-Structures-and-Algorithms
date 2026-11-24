// 2192. All Ancestors of a Node in a Directed Acyclic Graph
class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {

        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
            result.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            graph.get(edge[1]).add(edge[0]);
        }

        for(int i=0;i<n;i++){

            boolean[] visited = new boolean[n];

            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(i);

            while(!queue.isEmpty()){
                
                int curr = queue.poll();

                for(int j=0;j<graph.get(curr).size();j++){
                    
                    int node = graph.get(curr).get(j);

                    if(!visited[node]){
                        visited[node] = true;
                        queue.offer(node);
                    }
                }
            }

            for(int k=0;k<n;k++){
                if(k != i && visited[k]){
                    result.get(i).add(k);
                }
            }

        }
        return result;
    }
}
