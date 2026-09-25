class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        
        ArrayList<Integer> list = new ArrayList<>();

        int left = (int)(Math.pow(10,n-1));
        int right = (int)(Math.pow(10,n));

        for(int i=left;i<right;i++){

            if(fun(k,i)){
                list.add(i);
            }
        }

        int[] res = new int[list.size()];

        for(int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }

        return res;
    }

    public boolean fun(int x,int k){
        int temp = k%10;
        k/=10;
        while(k>0){
            int rem = k%10;
            if(Math.abs(temp-rem) != x){
                return false;
            }
            temp = rem;
            k/=10;
        }
        return true;
    }
}
