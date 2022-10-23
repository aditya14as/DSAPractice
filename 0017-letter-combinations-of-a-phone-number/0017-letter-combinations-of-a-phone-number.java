class Solution {
    List<String> ans=new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        helper(digits,"");
        return ans;
    }
    public void helper(String digits, String temp){
        if(digits.length()==0){
            if(temp.isEmpty()){
                return;
            }else{
                ans.add(temp);
                return;
            }
        }
        int digit = (digits.charAt(0)-'0');
        // System.out.println(digit);
        if(digit!=7 && digit!=8 && digit!=9){
            for(int i = (digit-2)*3; i<(digit-1)*3; i++){
                char ch = (char)('a'+i);
                helper(digits.substring(1),temp+ch);
            }
        }else if(digit==7){
            for(int i = (digit-2)*3; i<=(digit-1)*3; i++){
                char ch = (char)('a'+i);
                helper(digits.substring(1),temp+ch);
            }
        }else if(digit==8){
            for(int i = (digit-2)*3+1; i<=(digit-1)*3; i++){
                char ch = (char)('a'+i);
                helper(digits.substring(1),temp+ch);
            }
        }else{
            for(int i = (digit-2)*3+1; i<=(digit-1)*3+1; i++){
                char ch = (char)('a'+i);
                helper(digits.substring(1),temp+ch);
            }
        }
    }
}