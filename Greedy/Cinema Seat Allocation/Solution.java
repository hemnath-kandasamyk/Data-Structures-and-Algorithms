//1386. Cinema Seat Allocation
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        
        HashMap<Integer,Set<Integer>> map = new HashMap<>();

        for(int[] seat : reservedSeats){
            
            int row = seat[0];
            int col = seat[1];

            if(!map.containsKey(row)){
                map.put(row,new HashSet<>());
            }
            map.get(row).add(col);
        }

        int count = 0;
        for(Set<Integer> temp : map.values()){
            
            boolean left = true;
            boolean mid = true;
            boolean right = true;

            for(int i=2;i<=5;i++){
                if(temp.contains(i)){
                    left = false;
                    break;
                }
            }

            for(int i=4;i<=7;i++){
                if(temp.contains(i)){
                    mid = false;
                    break;
                }
            }
            for(int i=6;i<=9;i++){
                if(temp.contains(i)){
                    right = false;
                    break;
                }
            }

            if(left && right){
                count+=2;
            }
            else if(mid){
                count+=1;
            }
            else if(left || right){
                count+=1;
            }
        }
        count += (n-map.size())*2;
        return count;
    }
}
