1class Solution {
2    public int canCompleteCircuit(int[] gas, int[] cost) {
3        
4        int totalgas=0;
5        int totalcost=0;
6        for(int i=0;i<gas.length;i++){
7            totalgas+=gas[i];
8            totalcost+=cost[i];
9        }
10        if(totalcost>totalgas){
11            return -1;
12        }
13        int currgas=0;
14        int index=0;
15        for(int i=0;i<gas.length;i++){
16            currgas=(currgas+gas[i])-cost[i];
17            if(currgas<0){
18                currgas=0;
19                index=i+1;
20            }
21        }
22        return index;
23    }
24}