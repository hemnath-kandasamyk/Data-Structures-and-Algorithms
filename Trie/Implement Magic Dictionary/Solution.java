class MagicDictionary {

    class TrieNode{
        TrieNode[] child;
        boolean isword;

        public TrieNode(){
            this.child = new TrieNode[26];
            this.isword = false;
        }
    }

    TrieNode root;

    public MagicDictionary() {
        this.root = new TrieNode();
    }
    
    public void buildDict(String[] dictionary) {
        
        for(String str : dictionary){

            TrieNode current = root;

            for(char i : str.toCharArray()){

                int index = i-'a';

                if(current.child[index]==null){
                    current.child[index]=new TrieNode();
                }
                current = current.child[index];
            }
            current.isword = true;
        }
    }
    
    public boolean search(String searchWord) {
       
       return dfs(searchWord,true,0,this.root);
    }

    public boolean dfs(String word, boolean used , int index , TrieNode root){

        if(index==word.length()){
            return !used && root.isword;
        }

        int idx = word.charAt(index)-'a';

        if(root.child[idx] != null){

            if(dfs(word,used,index+1,root.child[idx])){
                return true;
            }
        }

        if(used){

            for(int i=0;i<26;i++){

                if(i==idx){
                    continue;
                }

                if(root.child[i]!=null){
                    if(dfs(word,false,index+1,root.child[i])){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

