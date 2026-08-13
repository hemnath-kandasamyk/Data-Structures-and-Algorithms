class Solution {
    public boolean isValid(String s) {
        
        String[] nums = s.split("\\.");
        
        
        if(nums.length !=4){
            return false;
        }
        for(int j=0;j<4;j++){
            int number = 0;
            if(nums[j].length()==0 || nums[j].length()>3){
                return false;
            }
            if(nums[j].length()>1 && nums[j].charAt(0)=='0'){
                return false;
            }
            for(char i : nums[j].toCharArray()){
                if(i>='0' && i<='9'){
                    number = (number*10)+(i-'0');
                }
                else{
                    return false;
                }
            }
            
            if(number<0 || number>255){
                return false;
            }
        }
        return true;
    }
}
