class Solution {
    public boolean validPalindrome(String s) {
        char[] arr = s.toCharArray();
        int start=0,end=arr.length-1;
        while(start<end){
            if(arr[start]!=arr[end]){
                boolean left  = isPali(arr,start+1,end);
                boolean right = isPali(arr,start,end-1);
                if(!left && !right){
                    return false;
                }
                else{
                    return true;
                }
            }
            start++;
            end--;
        }
        return true;
    }

    public boolean isPali(char[] arr,int s,int e){
        while(s<e){
            if(arr[s]!=arr[e]){
                return false;
            }
            s++;e--;
        }
        return true;
    }
}