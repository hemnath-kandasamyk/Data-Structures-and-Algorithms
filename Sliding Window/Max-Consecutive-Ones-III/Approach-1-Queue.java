class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        Queue<Integer> queue = new LinkedList<>();
        int left=0;
        int conseq=0;

        for(int right=0;right<n;right++){
            if(nums[right]==0){
                queue.add(right);
            }
            if(queue.size()>k){
                left=queue.poll()+1;
            }
            conseq=Math.max(right-left+1,conseq);
        }
        return conseq;
    }
}
