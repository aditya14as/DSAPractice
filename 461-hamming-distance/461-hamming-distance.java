class Solution {
    public int hammingDistance(int x, int y) {
        //xor x and y will give an integer having 1 where x and y have different bits
        int n = x^y;
        // now count the no of 1 bits
        int c =0;
        while(n!=0){
            c++;
            n = n&(n-1);
        }
        return c;
    }
}