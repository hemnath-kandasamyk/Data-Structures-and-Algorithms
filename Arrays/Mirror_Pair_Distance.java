class Solution {
    public int rev(int x){
        int rev=0;
        while(x!=0){
            rev=(rev*10)+(x%10);
            x/=10;
        }
        return rev;
    }
    public int minMirrorPairDistance(int[] nums) {
        int n=nums.length;
        int distance=n+1;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
              distance=Math.min(distance,i-map.get(nums[i]));
            }
            map.put(rev(nums[i]),i);
        }
        return distance==n+1?-1:distance;
    }
}
