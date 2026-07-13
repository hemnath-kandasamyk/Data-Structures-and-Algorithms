class Solution {
    boolean twoSum(int arr[], int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(target-arr[i])){
                return true;
            }
            map.put(arr[i],i);
        }
        return false;
    }
}
