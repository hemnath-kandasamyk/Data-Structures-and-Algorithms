class Solution {
    public int singleNumber(int[] nums) {
        int ans =0;
        for(int i=0;i<32;i++){
          int count=0;

          for(int num : nums){
            count+=(num&(1<<i))!=0?1:0;
          }
          ans=(ans) |((count%3)<<i);
        }
        return ans;
    }
}
