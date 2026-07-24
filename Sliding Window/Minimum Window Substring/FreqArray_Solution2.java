class Solution {
    public String minWindow(String s, String t) {
        
        int n = s.length();
        int m = t.length();

        if(m>n){
            return "";
        }
        
        int [] maxfreq = new int[128];
        int [] targetfreq = new int[128];

        int required = 0;

        for(char i : t.toCharArray()){

            if(targetfreq[i]==0){
                required++;
            }
            targetfreq[i]++;
        }

        int formed = 0;
        int startpoint = 0;
        int endpoint =Integer.MAX_VALUE;

        int left = 0;
        
        for(int right =0;right<n;right++){
            
            char ch = s.charAt(right);
            maxfreq[ch]++;

            if(targetfreq[ch]>0 && maxfreq[ch]==targetfreq[ch]){
                formed++;
            }

            while(formed==required){

                if(right-left<endpoint-startpoint){
                    endpoint = right;
                    startpoint = left;
                }

                char remove = s.charAt(left++);
                maxfreq[remove]--;
                
                if(targetfreq[remove]>0 && maxfreq[remove]<targetfreq[remove]){
                    formed--;
                }
            }
        }
        if(endpoint==Integer.MAX_VALUE){
            return "";
        }

        return s.substring(startpoint,endpoint+1);
    }
}
