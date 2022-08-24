class Solution {
    public boolean isPowerOfThree(int n) {
      return helper(n,0,1);
    }
    boolean helper(int n, int start,long multiply){
        if( multiply ==n){
            return true;
        }
        if(multiply > n){
            return false;
        }
        return helper(n,start+1,multiply*3);
    }
}