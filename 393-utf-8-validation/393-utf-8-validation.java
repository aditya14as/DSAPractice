class Solution {
    public boolean validUtf8(int[] data) {
        int ans = 0;        
        for(int idata : data){
            if(ans==0){
                if((idata>>7)==0b0){
                    ans = 0;
                } else if ((idata>>5)==0b110){
                    ans = 1;
                } else if ((idata>>4)==0b1110){
                    ans = 2;
                } else if ((idata>>3)==0b11110){
                    ans = 3;
                } else {
                    return false;
                }
            } else {
                if((idata>>6)==0b10){
                    ans--;
                } else {
                    return false;
                }
            }
        }
        return ans==0;
    }
}