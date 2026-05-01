//4. Median of Two Sorted Arrays
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int[] nums3=new int[n+m];
        int i=0,j=0,k=0;
        while(i<n && j<m){
            if(nums1[i]<nums2[j]){
              nums3[k++]=nums1[i++];
            }
            else{
                nums3[k++]=nums2[j++];
            }
        }
        while(i<n){
            nums3[k++]=nums1[i++];
        }
        while(j<m){
            nums3[k++]=nums2[j++];
        }
        int l=m+n;
        return l%2==0? (nums3[l/2]+nums3[l/2 -1])/2.0:nums3[l/2];
    }
}
