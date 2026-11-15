class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            graph.get(pre[1]).add(pre[0]);
        }

        int[] indegree = new int[numCourses];
        int count = 0;

        for(int i=0;i<numCourses;i++){
            for(int j=0;j<graph.get(i).size();j++){
                indegree[graph.get(i).get(j)]++;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for(int i =0;i<numCourses;i++){

            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int node = queue.poll();
            count++;

            for(int i=0;i<graph.get(node).size();i++){
                int neighbour = graph.get(node).get(i);
                indegree[neighbour]--;

                if(indegree[neighbour] == 0){
                    queue.offer(neighbour);
                }
            }
        }

        return count == numCourses;    
    }
}
