class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();
        for(int i = low;i<=high;i++){
            if(isseq(i)){
                list.add(i);
            }
        }
        return list;
    }

    public boolean isseq(int x){

        int prev = x%10;
        x/=10;

        while(x!=0){
            if(x%10 != prev-1){
                return false;
            }
            prev=x%10;
            x/=10;
        }
        return true;
    }
}