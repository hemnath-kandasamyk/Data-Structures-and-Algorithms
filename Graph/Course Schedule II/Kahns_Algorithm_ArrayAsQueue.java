// 210. Course Schedule II
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        int[] indegree = new int[numCourses];
        int[] order = new int[numCourses];

        int index = 0;
        int nodeidx = 0;


        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int edge[] : prerequisites){
            graph.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }

        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                order[index++] = i;
            }
        }

        while(nodeidx < index){

            int node = order[nodeidx++];

            for(int i=0;i<graph.get(node).size();i++){

                int neighbour = graph.get(node).get(i);
                indegree[neighbour]--;

                if(indegree[neighbour] == 0){
                    order[index++] = neighbour;
                }
            }
        }
        return (index != numCourses)?new int[]{}:order;
    }
}
