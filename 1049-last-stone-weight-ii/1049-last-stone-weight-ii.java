class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum =0;
        for(int i=0; i<stones.length; i++){
            sum+=stones[i];
        }
       HashMap<String,Integer> map = new HashMap<>();
        return helper(stones,0,sum,0,map);
    }
    public int helper(int[] stones, int sum,int tSum,int i,HashMap<String,Integer> map){
        String temp = i+"_"+sum;
        if(i==stones.length){
            return Math.abs(tSum-sum);
        }
        if(map.containsKey(temp)){
            return map.get(temp);
        }
        int l = helper(stones,sum,tSum,i+1,map);
        int r = helper(stones,sum+stones[i],tSum-stones[i],i+1,map);
        map.put(temp, Math.min(l,r));
        return Math.min(l,r);
    }
}