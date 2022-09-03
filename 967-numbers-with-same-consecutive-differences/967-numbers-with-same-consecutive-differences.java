class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> ans = new ArrayList<>();
        for(int i=1; i<=9; i++){
            helper(n-1,k,i,ans);
        }
        int[] arr = new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            arr[i]=ans.get(i);
        }
        return arr;
    }
    public void helper(int n, int k,int number,List<Integer> ans){
        if(n==0){
            ans.add(number);
            return;
        }
        
        int digit = number%10;
        if(digit-k>=0){
            
            helper(n-1,k,number*10+digit-k,ans);
        }
        if(digit+k<=9 && (digit-k != digit+k)){
           
            helper(n-1,k,number*10+digit+k,ans);
        }
        return;
    }
}