class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int freq = map.getOrDefault(c,0);
            if(freq ==1){
                return i;
            }
        }
        return -1;
    }
}