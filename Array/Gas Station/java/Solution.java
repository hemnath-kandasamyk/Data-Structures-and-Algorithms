class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int totalgas=0;
        int totalcost=0;
        for(int i=0;i<gas.length;i++){
            totalgas+=gas[i];
            totalcost+=cost[i];
        }
        if(totalcost>totalgas){
            return -1;
        }
        int currgas=0;
        int index=0;
        for(int i=0;i<gas.length;i++){
            currgas=(currgas+gas[i])-cost[i];
            if(currgas<0){
                currgas=0;
                index=i+1;
            }
        }
        return index;
    }
}