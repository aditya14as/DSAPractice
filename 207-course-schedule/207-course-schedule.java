class Solution {
    public boolean canFinish(int num, int[][] pre) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<num; i++){
            list.add(new ArrayList<>());
        }
        for(int i=0; i<pre.length; i++){
            list.get(pre[i][1]).add(pre[i][0]);
        }
        int[] degree = new int[num];
        for(int i=0; i<num ;i++){
            for(int j=0; j<list.get(i).size(); j++){
                degree[list.get(i).get(j)]++;
            }
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0; i<num; i++){
            if(degree[i]==0){
                q.add(i);
            }
        }
        int[] ans = new int[num];
        int idx = 0;
        while(q.size()>0){
            int n = q.remove();
            ans[idx++]=n;
            for(int j : list.get(n)){
                degree[j]--;
                if(degree[j]==0){
                    q.add(j);
                }
            }
        }
        if(idx==num){
            return true;
        }
        return false;
    }
}