class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int[][] arr = new int[plantTime.length][2];
        for(int i=0; i<arr.length; i++){
            arr[i][0]=plantTime[i];
            arr[i][1]=growTime[i];
        }
        Arrays.sort(arr,(a,b)->(b[1]-a[1]));
        int plant = 0;
        int ans = 0;
        for(int i=0; i<plantTime.length; i++){
            // System.out.println(arr[i][0]+"@"+arr[i][1]);
            plant = arr[i][0]+plant;
            ans = Math.max(ans,plant+arr[i][1]);
            
        }
        // System.out.println(plant);
        return ans;
    }
}