class Solution {
    List<String> result = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>(wordDict);
        helper(s,set,0,list);
        return result;
    }
    public void helper(String s, HashSet<String> set, int i, List<String> list){
        if(i==s.length()){
           String str = "";
            for(int j = 0; j<list.size(); j++){
                str= str+list.get(j)+" ";
            }
            result.add(str.substring(0,str.length()-1));
            return;
        }
        for(int k=i; k<s.length(); k++){
            if(set.contains(s.substring(i,k+1))){
                list.add(s.substring(i,k+1));
                helper(s,set,k+1,list);
                list.remove(list.size()-1);
                
            }
        }
    }
}