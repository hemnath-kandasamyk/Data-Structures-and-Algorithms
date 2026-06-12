//209. Minimum Size Subarray Sum
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left =0;
        int n = nums.length;
        int sum=0;
        int window=n+1;

        for(int right =0;right<n;right++){
            sum+=nums[right];

            while(sum>=target){
                window=Math.min(window,right-left+1);
                sum-=nums[left++];
            }
        }
        return window==n+1?0:window;
    }
}
