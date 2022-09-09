class Solution {
    public int numberOfWeakCharacters(int[][] prop) {
        // Sort array in Decreasing order of their attack, if attack are equal then sort it in increasing order of their defence
         // When we come across a defense value smaller than current max, we know it should be a weak character because it cannot be coming from a character with same attack because same attach characters are ordered ascending by defense
        Arrays.sort(prop,(a,b)-> (a[0]==b[0])?a[1]-b[1]:b[0]-a[0]);
        int max = Integer.MIN_VALUE;
        int ans = 0;
        for(int i=0; i<prop.length; i++){
            if(prop[i][1]<max){
                ans++;
            }else{
                max=prop[i][1];
            }
        }
        return ans;
    }
}