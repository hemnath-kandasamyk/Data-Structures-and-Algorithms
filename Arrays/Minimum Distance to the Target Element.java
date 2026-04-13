class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
      int mini=Integer.MAX_VALUE;
      for(int i=nums.length-1;i>=0;i--){
        if(nums[i]==target){
            mini=Math.min(mini,Math.abs(i-start));
            if(mini==0){
                return 0;
            }
        }
      }  
      return mini==Integer.MAX_VALUE?-1:mini;
    }
}
