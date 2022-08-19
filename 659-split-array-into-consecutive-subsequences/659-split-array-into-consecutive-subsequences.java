class Solution {

    public boolean isPossible(int[] nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[1] == b[1]) {
                    int la = a[1] - a[0] + 1;
                    int lb = b[1] - b[0] + 1;
                    return la - lb;
                } else {
                    return a[1] - b[1];
                }
            }
        );
        for (int i : nums) {
            while (pq.size() > 0 && pq.peek()[1] + 1 < i) {
                int[] r = pq.remove();
                if(r[1]-r[0]+1<3){
                    return false;
                }
            }
            if(pq.size()==0 || pq.peek()[1]==i){
                pq.add(new int[]{i,i});
            }else{
                int[] pr = pq.remove();
                pq.add(new int[]{pr[0],i});
            }
        }
        while(pq.size()>0){
            int[] pr = pq.remove();
            if(pr[1]-pr[0]+1 < 3){
                return false;
            }
        }
        return true;
    }
}
