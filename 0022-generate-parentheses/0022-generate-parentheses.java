class Solution {
    List<String> ans= new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        helper(n,0,0,"");
        return ans;
    }
    public void helper(int n, int left, int right, String str){
        if(str.length()==n*2){
            ans.add(str);
            return;
        }
        if(left<n){
            helper(n,left+1,right,str+"(");
        }
        if(left>right){
            helper(n,left,right+1,str+")");
        }
    }
}