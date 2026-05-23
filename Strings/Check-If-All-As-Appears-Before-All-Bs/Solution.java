//2124. Check if All A's Appears Before All B's
class Solution {
    public boolean checkString(String s) {
       boolean flag=false;
       for(char i:s.toCharArray()){
        if(i=='b'){
            flag=true;
        }
        if(i=='a' && flag){
            return false;
        }
       }
       return true; 
    }
}
