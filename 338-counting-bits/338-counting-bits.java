class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n+1];
        arr[0]=0;
        for(int i=1; i<arr.length; i++){
            int temp = i;
            int c = 0;
            while(temp!=0){
               temp = temp & (temp-1);
                c++;
            }
            arr[i] = c;
        }
        return arr;
    }
}