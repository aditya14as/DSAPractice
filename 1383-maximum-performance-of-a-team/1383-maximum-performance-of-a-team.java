class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] eng = new int[n][2];
        for(int i=0; i<n; i++){
            eng[i][0]=speed[i];
            eng[i][1]=efficiency[i];
        }
        Arrays.sort(eng,(a,b)->b[1]-a[1]);
        PriorityQueue<Integer> q = new PriorityQueue<>(k);
        long ans=0;
        long tSpeed = 0;
        for(int i=0; i<n; i++){
            if(q.size()>=k){
                tSpeed = tSpeed - q.remove(); 
            }
            tSpeed = tSpeed + eng[i][0];
            q.add(eng[i][0]);
            ans = Math.max(ans,tSpeed*eng[i][1]);
        }
        return (int)(ans%1000000007);
    }
}