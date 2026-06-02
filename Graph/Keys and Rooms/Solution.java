//841. Keys and Rooms
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {        
        boolean[] keys = new boolean[rooms.size()];
        Queue<Integer> queue= new LinkedList<>();
        queue.add(0);
        keys[0]=true;
        int count=1;
        while(!queue.isEmpty()){
            int curr=queue.poll();
            for(int room:rooms.get(curr)){
              if(!keys[room]){
                keys[room]=true;
                queue.add(room);
                count++;
              }
            }
        }
        return count==rooms.size();
    }
}
