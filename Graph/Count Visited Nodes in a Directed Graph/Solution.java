// 2876. Count Visited Nodes in a Directed Graph
class Solution {
    public int[] countVisitedNodes(List<Integer> edges) {
        
        int n = edges.size();

        int[] indegree = new int[n];
        int[] result = new int[n];

        Queue<Integer> queue = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();

        for(int i : edges){
            indegree[i]++;
        }

        for(int i=0;i<n;i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){

            int node = queue.poll();
            stack.push(node);

            int next = edges.get(node);
            indegree[next]--;

            if(indegree[next] == 0){
                queue.offer(next);
            }
        }

        for(int i=0;i<n;i++){

            if(indegree[i]>0 && result[i] == 0){

                int curr = i;
                int cyclelength = 0;

                do{
                    curr = edges.get(curr);
                    cyclelength++;
                }while(curr != i);

                curr = i;

                do{
                    result[curr] = cyclelength;
                    curr = edges.get(curr);
                }while(curr != i);
            }
        }

        while(!stack.isEmpty()){

            int node = stack.pop();
            result[node] = result[edges.get(node)] +1;
        }

        return result;
    }
}
