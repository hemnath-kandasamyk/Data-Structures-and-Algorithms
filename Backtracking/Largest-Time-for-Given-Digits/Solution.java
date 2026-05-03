//949. Largest Time for Given Digits
class Solution {
    private String result="";
    private boolean processed=false;
    public String largestTimeFromDigits(int[] arr) {
        int[] freq=new int[10];
        for(int i:arr){
            freq[i]++;
        }
        backtrack("",freq);
        return result;
    }
    public void backtrack(String p , int[] freq){
        if(p.length()==5){
            if(processed){
                return;
            }
            processed=true;
            result=result+p;
            return;
        }
        if(p.length()==4 && !processed){
            for(int i=9;i>=0;i--){
                if(freq[i]!=0){
                    freq[i]--;
                    backtrack(p+i,freq);
                    freq[i]++;
                }
            }
        }
        if(p.length()==3 && !processed){
            for(int i=5;i>=0;i--){
                if(freq[i]!=0){
                    freq[i]--;
                    backtrack(p+i,freq);
                    freq[i]++;
                }
            }
        }
        if(p.length()==1 && !processed){
           if(p.charAt(0)=='2'){
            for(int i=3;i>=0;i--){
                if(freq[i]!=0){
                    freq[i]--;
                    backtrack(p+i+":",freq);
                    freq[i]++;
                }
            }
           }
           else{
            for(int i=9;i>=0;i--){
                if(freq[i]!=0){
                    freq[i]--;
                    backtrack(p+i+":",freq);
                    freq[i]++;
                }
            }
           }
        }
        if(p.length()==0){
            for(int i=2;i>=0;i--){
                if(freq[i]!=0){
                    freq[i]--;
                    backtrack(p+i,freq);
                    freq[i]++;
                }
            }
        }
    }
}
