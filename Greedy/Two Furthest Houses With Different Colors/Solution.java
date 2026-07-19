//2078. Two Furthest Houses With Different Colors
class Solution {
    public int maxDistance(int[] colors) {
        
        int start =0 , end = colors.length-1;
        int first=0;
        int last = end;
        
        while(first<=end && colors[first]==colors[end]){
            first++;
        }
        while(last>0 && colors[last]==colors[start]){
            last--;
        }
        return Math.max(end-first,last-start);
    }
}
