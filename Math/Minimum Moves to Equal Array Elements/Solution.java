class Solution {
    public int minMoves(int[] nums) {
        
        int sum = 0;
        int n = nums.length;
        int min = nums[0];

        for(int i : nums){
            sum = sum + i;
            min = Math.min(min,i);
        }
        
        return sum - n*min;
    }
}
