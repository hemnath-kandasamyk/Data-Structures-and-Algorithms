class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie trieObj = new Trie();

        for(int num : nums){
            trieObj.insert(num);
        }

        int MaxXor = 0;
        for (int num : nums){
            MaxXor = Math.max(trieObj.getMaxXor(num),MaxXor);
        }

        return MaxXor;
    }
}

class Trie{

    class TrieNode{
        TrieNode zero;
        TrieNode one;
    }
    TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(int num){
        TrieNode curr = root;

        for(int i=31;i>=0;i--){
            int bit = (num>>i)&1;

            if(bit==0){
                
                if(curr.zero ==null){
                    curr.zero = new TrieNode();
                }
                curr = curr.zero;
            }
            else{
                if(curr.one == null){
                    curr.one = new TrieNode();
                }
                curr = curr.one;
            }
        }
    }

    public int getMaxXor(int num){

        TrieNode curr = root;
        int xor =0;

        for(int i=31;i>=0;i--){

            int bit = (num>>i)&1;

            if(bit==0){

                if(curr.one!=null){
                  xor |= (1<<i);
                  curr = curr.one;
                }
                else{
                    curr = curr.zero;
                }
            }

            else{

                if(curr.zero!=null){
                    xor |=(1<<i);
                    curr = curr.zero;
                }
                else{
                    curr = curr.one;
                }
            }
        }
        return xor;
    }
}
