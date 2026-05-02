//3819. Rotate Non Negative Elements3819. Rotate Non Negative Elements
class Solution {
    public int[] rotateElements(int[] nums, int k) {
        List<Integer> list=new ArrayList<>();
        for(int i:nums){
            if(i>=0){
                list.add(i);
            }
        }
        int n=list.size();
        if(n==0){
            return nums;
        }
        k=k%n;
        reverse(list,0,k-1);
        reverse(list,k,n-1);
        reverse(list,0,n-1);
        int idx=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0){
                nums[i]=list.get(idx++);
            }
        }
        return nums;
    }
    public void reverse(List<Integer> list,int s,int e){
        while(s<e){
            int temp=list.get(s);
            list.set(s,list.get(e));
            list.set(e,temp);
            s++;e--;
        }
    }
}
