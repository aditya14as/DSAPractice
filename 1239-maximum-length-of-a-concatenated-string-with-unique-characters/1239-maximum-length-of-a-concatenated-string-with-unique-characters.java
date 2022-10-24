class Solution {
    int maxL = 0;
    public int maxLength(List<String> arr) {
        helper(arr,"",0);
        return maxL;
    }
    public void helper(List<String> arr,String str,int start){
        if(isUnique(str)){
            maxL = Math.max(str.length(),maxL);
        }else{
            return;
        }
        if(start==arr.size()){
            return;
        }
        helper(arr,str+arr.get(start),start+1);
        helper(arr,str,start+1);
    }
    public boolean isUnique(String str){
        int[] freq = new int[26];
        for(int i=0; i<str.length(); i++){
            int ch = str.charAt(i)-'a';
            if(freq[ch]==0){
                freq[ch]++;
            }else{
                return false;
            }
        }
        return true;
    }
}