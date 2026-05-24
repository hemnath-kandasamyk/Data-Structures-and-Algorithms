//13. Roman to Integer
class Solution {
    public int romanToInt(String s) {
        int number=0;
        for(int i=s.length()-1;i>=0;i--){
            int n=convert(s.charAt(i));
            number=((4*n)<number)?number-n:number+n;
        }
        return number;
    }
    public int convert(char i){
        switch(i){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }
}
