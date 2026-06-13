//1004. Max Consecutive Ones III
class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        
        int left=0;
        int conseq=0;
        int zero=0;

        for(int right=0;right<n;right++){
            if(nums[right]==0){
                zero++;
            }
            while(zero>k){
                if(nums[left]==0){
                    zero--;
                }
                left++;
            }
            
            conseq=Math.max(right-left+1,conseq);
        }
        return conseq;
    }
}
