class Solution {
    public int maxProduct(int[] nums) {
        int maxP=Integer.MIN_VALUE;
        int prod = 1;
        for(int i=0; i<nums.length;i++){
            prod = prod*nums[i];
            maxP = Math.max(maxP,prod);
            if(prod==0){
                prod = 1;
            }
            
        }
        prod = 1;
        for(int i=nums.length-1; i>=0;i--){
            prod = prod*nums[i];
            maxP = Math.max(maxP,prod);
            if(prod==0){
                prod = 1;
            }
            
        }
        return maxP;
        // return helper(nums,0,1,dp);
    }
//     public int helper(int[] nums,int i, int prod,HashMap<String,Integer> dp){
//         if(i==nums.length){
//             return prod;
//         }
//         String key = i+"*"+prod;
//         if(dp.containsKey(key)){
//             return dp.get(key);
//         }
        
//         int t = Math.max(helper(nums,i+1,prod*nums[i],dp),helper(nums,i+1,nums[i],dp));
//         if(i==0){
//             prod=nums[i];
    
//         }
//         dp.put(key,Math.max(prod,t));
//         return Math.max(prod,t);
//     }
}