// 210. Course Schedule II
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int [] result = new int[numCourses];
        int[] indegree = new int[numCourses];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();

        int index = 0;

        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){

            int node = queue.poll();
            result[index++] = node;

            for(int i=0;i<graph.get(node).size();i++){
                
                int neighbour = graph.get(node).get(i);
                indegree[neighbour]--;

                if(indegree[neighbour] == 0){
                    queue.offer(neighbour);
                }
            }
        }

        return (index != numCourses)?new int[]{}:result;
    }
}
