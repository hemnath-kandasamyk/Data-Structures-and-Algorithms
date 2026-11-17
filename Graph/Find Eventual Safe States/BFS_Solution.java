// 802. Find Eventual Safe States
// Using BFS + KAHN'S Algorithm + Topological Sort
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        List<Integer> safenodes = new ArrayList<>();
        ArrayList<ArrayList<Integer>> InvertedGraph = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();

        int v = graph.length;
        
        int[] indegree = new int[v];

        for(int i=0;i<v;i++){
            InvertedGraph.add(new ArrayList<>());
        }

        for(int i=0;i<v;i++){
            for(int j=0;j<graph[i].length;j++){
                InvertedGraph.get(graph[i][j]).add(i);
                indegree[i]++;
            }
        }

        for(int i=0;i<v;i++){

            if(indegree[i] == 0){
                queue.offer(i);
            }
        }


        while(!queue.isEmpty()){

            int node = queue.poll();

            for(int i=0;i<InvertedGraph.get(node).size();i++){

                int neighbour = InvertedGraph.get(node).get(i);
                indegree[neighbour]--;

                if(indegree[neighbour] == 0){
                    queue.offer(neighbour);
                }
            }
        }

        for(int i=0;i<v;i++){
            if(indegree[i] == 0){
                safenodes.add(i);
            }
        }

        return safenodes;
    }
}
