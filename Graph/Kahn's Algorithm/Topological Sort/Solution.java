// Topological Sort Kahn's Algorithm
class Solution {
    ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> adj) {
       
       ArrayList<Integer> result = new ArrayList<>();
       
       int v = adj.size();
       
       int[] indegree = new int[v];
       
       for(int i=0;i<v;i++){
           for(int j=0;j<adj.get(i).size();j++){
               indegree[adj.get(i).get(j)]++;
           }
       }
       
       Queue<Integer> queue = new ArrayDeque<>();
       
       for(int i=0;i<v;i++){
           if(indegree[i] == 0){
               queue.offer(i);
           }
       }
       
       while(!queue.isEmpty()){
           int node = queue.poll();
           result.add(node);
           
           for(int i=0;i<adj.get(node).size();i++){
               int neighbour = adj.get(node).get(i);
               indegree[neighbour]--;
               
               if(indegree[neighbour] == 0){
                   queue.offer(neighbour);
               }
           }
       }
       
       return result;
    }
}
