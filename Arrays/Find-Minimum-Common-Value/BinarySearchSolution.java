class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        for(int i:nums1){
            if(BinarySearch(nums2,i)){
                return i;
            }
        }
        return -1;
    }
    public boolean BinarySearch(int[] nums,int target){
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                return true;
            }
            else if(nums[mid]<target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return false;
    }
}
