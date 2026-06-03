//207. Course Schedule
class Solution {
    int state[];
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph =new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites){
            graph.get(pre[1]).add(pre[0]);
        }

        state=new int[numCourses];

        for(int i=0;i<numCourses;i++){
            if(!dfs(i,graph)){
                return false;
            }
        }
        return true;
    }
    public boolean dfs(int node,List<List<Integer>> graph){
        if(state[node]==1){
            return false;
        }
        if(state[node]==2){
            return true;
        }

        state[node]=1;
        for(int next : graph.get(node)){
            if(!dfs(next,graph)){
                return false;
            }
        }
        state[node]=2;
        return true;
    }
}
