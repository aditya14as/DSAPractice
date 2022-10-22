class Solution {

    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }
        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int req = t.length();
        int curr = 0;
       
        while (j < s.length()) {
            char ch = s.charAt(j);
            if(map[ch]>0){
                curr++;
            }
            map[ch]--;
            j++;
            while (curr == req) {
                if(j-i < min && curr==req){
                    start = i;
                    end = j;
                    min = j-i;
                }
                char c = s.charAt(i);
                map[c]++;
                if(map[c]>0){
                    curr--;
                }
                i++;
            }
            
        }
        if(min == Integer.MAX_VALUE) return "";
        return s.substring(start,end);
    }
}
