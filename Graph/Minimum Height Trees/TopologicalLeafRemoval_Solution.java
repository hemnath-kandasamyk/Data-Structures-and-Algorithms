// 310. Minimum Height Trees
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        int[] degree = new int[n];
        int remainingnode = n;

        if(n==1){
            return  Arrays.asList(0);
        }

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);

            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        for(int i=0;i<n;i++){
            if(degree[i] == 1){
                queue.offer(i);
            }
        }

        while(remainingnode >2){

            int size = queue.size();
            remainingnode -= size;

            for(int i=0;i<size;i++){

                int node = queue.poll();

                for(int nei : graph.get(node)){
                    degree[nei]--;

                    if(degree[nei] == 1){
                        queue.offer(nei);
                    }
                }
            }

        }

        return new ArrayList<>(queue);
    }
}
