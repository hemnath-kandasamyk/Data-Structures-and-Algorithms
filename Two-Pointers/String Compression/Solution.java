class Solution {
    public int compress(char[] chars) {
        
        int count = 1;
        int write = 0;
        for(int read = 1;read<chars.length;read++){
            if(chars[read]==chars[read-1]){
                count++;
                continue;
            }
            chars[write]=chars[read-1];
            write = (count==1)?write+1:update(chars,count,write);
            count=1;
        }
        chars[write]=chars[chars.length-1];
        write=(count>1)?update(chars,count,write):write+1;
        return write;
    }
    public int update(char[] nums,int count,int write){
        int length = (int)Math.log10(count)+1;
        int pow = (int)Math.pow(10,length-1);
        write++;
        while(length>0){
            length--;
            nums[write++]=(char)(count/pow +'0');
            count=count%pow;
            pow/=10;
        }
        return write;
    }
}
