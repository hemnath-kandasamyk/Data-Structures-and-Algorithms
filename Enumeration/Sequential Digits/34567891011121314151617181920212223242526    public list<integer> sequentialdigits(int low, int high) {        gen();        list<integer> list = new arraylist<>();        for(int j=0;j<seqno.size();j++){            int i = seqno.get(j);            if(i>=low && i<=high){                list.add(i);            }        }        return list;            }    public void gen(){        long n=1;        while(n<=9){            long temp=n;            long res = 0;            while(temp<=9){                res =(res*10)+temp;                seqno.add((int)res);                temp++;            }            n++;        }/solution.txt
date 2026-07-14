    public List<Integer> sequentialDigits(int low, int high) {
        gen();
        List<Integer> list = new ArrayList<>();
        for(int j=0;j<seqno.size();j++){
            int i = seqno.get(j);
            if(i>=low && i<=high){
                list.add(i);
            }
        }
        return list;        
    }

    public void gen(){
        long n=1;
        while(n<=9){
            long temp=n;
            long res = 0;
            while(temp<=9){
                res =(res*10)+temp;
                seqno.add((int)res);
                temp++;
            }
            n++;
        }
