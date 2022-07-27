class Solution {
    public int minSteps(int n) {
        int count = 0;
        int buffer =0;
        int current = 1;
        while(current<n){
            int rest = n-current;
            if(rest%current==0){
                buffer = current;
                count=count+2;
                current = current+buffer;
            }else{
                count++;
                current = current+ buffer;
            }
        }
        return count;
    }
}