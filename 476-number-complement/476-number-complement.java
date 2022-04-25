class Solution {
    public int findComplement(int n) {
        //no of length of n
        int m = (int)(Math.log(n)/Math.log(2))+1;
        // left shifting to make all bits set.
        int mask = (1<<m)-1;
        // XOR operator does our work here to complement the value.
        return mask ^ n;
    }
}