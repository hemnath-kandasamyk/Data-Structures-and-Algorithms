//210. Course Schedule II
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        ArrayList<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int[] indegree=new int[numCourses];
        for(int pre[] : prerequisites){

            int course=pre[0];
            int prerequest=pre[1];

            graph.get(prerequest).add(course);
            indegree[course]++;
        }
        Queue<Integer> queue=new LinkedList<>();

        for(int i=0;i<numCourses;i++){
          if(indegree[i]==0){
            queue.add(i);
          }
        }

        int[] order =new int[numCourses];
        int index=0;
        while(!queue.isEmpty()){
            int node=queue.poll();
            order[index++]=node;

            for(int next : graph.get(node)){
                indegree[next]--;

                if(indegree[next]==0){
                    queue.add(next);
                }
            }
        }
        return (index==numCourses)?order:new int[0];
    }
}
