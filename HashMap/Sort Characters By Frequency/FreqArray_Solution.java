class Solution {
    public String frequencySort(String s) {
        
        char[] nums = s.toCharArray();
        int n = nums.length;

        List<Character>[] list = new ArrayList[n+1];
        int[] freq = new int[128];

        for(char i : nums){
            freq[i]++;
        }

        for(int i=0;i<128;i++){

            if(list[freq[i]]==null){
                list[freq[i]] = new ArrayList<>();
            }
            list[freq[i]].add((char)(i));
        }
        int index =0;
        for(int i=n;i>0;i--){

            if(list[i]!=null){
                for(char j : list[i]){
                    for(int k=0;k<i;k++){
                        nums[index++]=j;
                    }
                }
            }
        }
        return new String(nums);
    }
}
