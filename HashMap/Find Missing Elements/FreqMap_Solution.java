//
class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        
        int low = nums[0];
        int high = nums[0];

        boolean[] flag = new boolean[101];

        for(int num : nums){
            low = Math.min(low,num);
            high = Math.max(high,num);
            flag[num] =true;
        }

        List<Integer> missing = new ArrayList<>();

        for(int i = low;i<high;i++){

            if(!flag[i]){
                missing.add(i);
            }
        }

        return missing;
    }
}
