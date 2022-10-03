class Solution {
    public int minCost(String color, int[] time) {
        int count =0;
        int prev = 0;
        int i =1;
        while(i<color.length()){
            if(color.charAt(prev)==color.charAt(i)){
                count = count + Math.min(time[i],time[prev]);
                if(time[i]>time[prev]){
                    prev = i;
                }
                i=i+1;
            }else{
                prev = i;
                i=i+1;
            }
        }
        return count;
    }
}