class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        List<int[]> list1 = new ArrayList<>();
        List<int[]> list2 = new ArrayList<>();
        for(int i=0; i<img1.length; i++){
            for(int j=0; j<img1.length; j++){
                if(img1[i][j]==1){
                    int[] temp = {i,j};
                    list1.add(temp);
                }
            }
        }
        for(int i=0; i<img2.length; i++){
            for(int j=0; j<img2.length; j++){
                if(img2[i][j]==1){
                    int[] temp = {i,j};
                    list2.add(temp);
                }
            }
        }
        HashMap<String, Integer> map = new HashMap<>();
        int ans=0;
        for(int i=0; i<list1.size(); i++){
            for(int j=0; j<list2.size(); j++){
                int row = list1.get(i)[0]-list2.get(j)[0];
                int col = list1.get(i)[1]-list2.get(j)[1];
                String temp = row+"&"+col;
                map.put(temp,map.getOrDefault(temp,0)+1);
                ans = Math.max(ans,map.get(temp));
            }
        }
        return ans;
    }
}