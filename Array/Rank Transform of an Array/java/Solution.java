class Solution {
    public int[] arrayRankTransform(int[] arr) {
        
        int n = arr.length;
        int[] temp=Arrays.copyOf(arr,n);
        Arrays.sort(temp);
        HashMap<Integer,Integer> map = new HashMap<>();
        int rank=1;
        for(int i=0;i<n;i++){
            if(i>0 && temp[i]==temp[i-1]){
                continue;
            }
            map.put(temp[i],rank);
            rank++;
        }
        for(int i=0;i<n;i++){
            arr[i]=map.get(arr[i]);
        }
        return arr;
        
    }
}