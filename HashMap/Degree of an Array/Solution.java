class Solution {
    public int findShortestSubArray(int[] nums) {
        
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            
            if(!map.containsKey(nums[i])){
                map.put(nums[i],new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
        int si=-1,ei=-1;

        int maxfreq=0;

        for(int key : map.keySet()){
            int size=map.get(key).size();
            
            int first = map.get(key).get(0);
            int last  = map.get(key).get(size-1);

            if(size>maxfreq){
                si=first;
                ei=last;
                maxfreq=size;
            }

            else if(maxfreq==size){
                if(last-first<ei-si){
                    si=first;
                    ei=last;
                }
            }
        }
        return ei-si+1;
    }
}
