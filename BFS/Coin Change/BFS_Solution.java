//322. Coin Change
class Solution {
    public int coinChange(int[] coins, int amount) {

        if(amount==0){
            return 0;
        }
        
        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();

        int mincoins = 0;
        queue.add(amount);
        set.add(amount);

        while(!queue.isEmpty()){
            mincoins++;
            int size = queue.size();
            for(int i=0;i<size;i++){
                int current = queue.poll();
                for(int coin : coins){
                    int need = current-coin;
                    if(need==0){
                        return mincoins;
                    }
                    if(need>0 && !set.contains(need)){
                        set.add(need);
                        queue.add(need);
                    }
                }
            }
        }

        return -1;

    }
}
