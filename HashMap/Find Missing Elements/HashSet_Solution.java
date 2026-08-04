class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        
        int low = nums[0];
        int high = nums[0];

        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            low = Math.min(low,num);
            high = Math.max(high,num);
            set.add(num);
        }

        List<Integer> missing = new ArrayList<>();

        for(int i = low;i<high;i++){

            if(!set.contains(i)){
                missing.add(i);
            }
        }

        return missing;
    }
}
