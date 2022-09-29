class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> q = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(q.size()>0 && ch == q.peek().ch){
                q.peek().freq++;
            }else{
                q.add(new Pair(ch,1));
            }
            if(q.peek().freq==k){
                q.pop();
            }
        }
        String ans = "";
        int l = q.size();
        for(int i=0; i<l; i++){
            Pair p = q.pop();
            for(int j=0; j<p.freq; j++){
                ans += p.ch;
            }
        }
        String ans2 = "";
        for(int i=0; i<ans.length(); i++){
            ans2+=ans.charAt(ans.length()-1-i);
        }
        return ans2;
    }
}
class Pair{
    char ch;
    int freq;
    Pair(char ch, int freq){
        this.ch = ch;
        this.freq = freq;
    }
}