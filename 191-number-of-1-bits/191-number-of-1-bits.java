public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int c = 0;
//         while(n!=0){
            
//             if((n&1) == 1){
//                 c = c+1;
//             }
//             n=n>>>1;
//         }
        
        //Brian Kernighan’s Algorithm: 
        //The beauty of this solution is the number of times it loops is equal to the number of set bits in a given integer. 
        while(n!=0){
            n=n&(n-1);
            c++;
        }
        return c;
    }
}