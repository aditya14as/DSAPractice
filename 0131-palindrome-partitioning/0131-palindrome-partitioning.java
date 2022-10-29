class Solution {
    List<List<String>> list = new ArrayList<>();
    public List<List<String>> partition(String s) {
        helper(s,new ArrayList<>(),0);
        return list;
    }
    public void helper(String s,List<String> temp,int start){
        if(start==s.length()){
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start; i<s.length(); i++){
            if(isPal(s,start,i)){
                temp.add(s.substring(start,i+1));
                helper(s,temp,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
    public boolean isPal(String s, int l, int h){
        while(l<h){
            if(s.charAt(l)!=s.charAt(h)) return false;
            l++;
            h--;
        }
        return true;
    }
}