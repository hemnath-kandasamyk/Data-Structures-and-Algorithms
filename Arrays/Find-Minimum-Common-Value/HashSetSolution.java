class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
    HashSet<Integer> set=new HashSet<>();
    int n=nums1.length;
    int m=nums2.length;
    for(int i=0;i<n;i++){
        set.add(nums1[i]);
    }  
    for(int j=0;j<m;j++){
        if(set.contains(nums2[j])){
            return nums2[j];
        }
    }
    return -1;
    }
}
