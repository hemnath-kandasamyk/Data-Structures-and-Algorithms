class Solution {
    public String frequencySort(String s) {
        
        char[] nums = s.toCharArray();
        int n = nums.length;

        List<Character>[] list = new ArrayList[n+1];
        HashMap<Character,Integer> map = new HashMap<>();

        for (char i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        
        for (char key : map.keySet()){
            if(list[map.get(key)]==null){
                list[map.get(key)] = new ArrayList<>();
            }
            list[map.get(key)].add(key);
        }
        int index = 0;
        for(int i= n;i>=0;i--){
          if(list[i]!=null){
            for (char j : list[i]){
                for (int k=0;k<i;k++){
                    nums[index++] = j;
                }
            }
          }
        }
        return new String(nums);
    }
}
