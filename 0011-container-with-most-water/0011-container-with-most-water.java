class Solution {
    public int maxArea(int[] height) {
        int ansArea = 0;
        int i=0; 
        int j=height.length-1;
        while(i<j){
            int area = (j-i)*(Math.min(height[i],height[j]));
            ansArea = Math.max(area,ansArea);
            if(height[i]>height[j]){
                j--;
            }else if(height[i]<height[j]){
                i++;
            }else{
                i++;
                j--;
            }
        }
        return ansArea;
    }
}