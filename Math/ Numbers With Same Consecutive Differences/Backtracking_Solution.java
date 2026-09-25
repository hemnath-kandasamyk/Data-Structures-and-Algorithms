// 967. Numbers With Same Consecutive Differences
class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        
        for(int i=1;i<=9;i++){
            backtrack(i,k,n-1);
        }

        int[] res = new int[list.size()];

        for(int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }

        return res;
    }

    ArrayList<Integer> list = new ArrayList<>();

    public void backtrack(int num, int diff,int size){

        if(size<0){
            return;
        }

        if(size==0){
            list.add(num);
            return;
        }

        int temp = num%10;

        if(temp-diff>=0){
            backtrack((num*10)+(temp-diff),diff,size-1);
        }
        
        if(temp+diff<=9 && diff>0){
            backtrack((num*10)+(temp+diff),diff,size-1);
        }

    }
}
