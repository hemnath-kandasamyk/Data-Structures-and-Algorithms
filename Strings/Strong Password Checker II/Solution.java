class Solution {
    public boolean strongPasswordCheckerII(String password) {

    if(password.length()<8){
        return false;
    }
    
    boolean up = false;
    boolean lc = false;
    boolean digit = false;
    boolean spc = false;

    for(int i=0;i<password.length();i++){
        char ch = password.charAt(i);

        if(i>0 && ch==password.charAt(i-1)){
            return false;
        }

        if(ch>='A' && ch<='Z'){
            up = true;
        }
        else if(ch>='a' && ch<='z'){
            lc = true;
        }
        else if(ch>='0' && ch<='9'){
            digit = true;
        }
        else{
            spc = true;
        }
    }
    return up && lc && digit && spc;
    }
}
