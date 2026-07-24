class Solution {
    public String minWindow(String s, String t) {
        
        int n = s.length();
        int m = t.length();

        if(m>n){
            return "";
        }
        int [] freq2 = new int[128];
        int [] freq1 = new int[128];

        for(int i=0;i<m;i++){
            freq2[t.charAt(i)]++;
            freq1[s.charAt(i)]++;
        }

        int left =0;
        int right = n+1;
        if(isEqual(freq1,freq2)){
            left=0;
            right=m-1;
        }
        int ptr =0;
        for(int i=m;i<n;i++){
            freq1[s.charAt(i)]++;
            while(isEqual(freq1,freq2)){
                if(right-left>i-ptr){
                    left=ptr;
                    right=i;
                }
                freq1[s.charAt(ptr++)]--;
            }
        }
        if(right==n+1){
            return "";
        }
        return s.substring(left,right+1);
    }

    public boolean isEqual(int[] a,int[] b){
        for(int i=0;i<128;i++){
            if(a[i]<b[i]){
                return false;
            }
        }
        return true;
    }
}
