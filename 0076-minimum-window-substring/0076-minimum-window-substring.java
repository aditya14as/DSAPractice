class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for(int i=0; i<t.length(); i++){
            map[t.charAt(i)]++;
        }
        int i = 0;
        int j = 0;
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        int req = t.length();
        int curr = 0;
        while(j<s.length()){
            char c = s.charAt(j);
            if(map[c]>0){
                curr ++;
            }
            map[c]--;
            j++;
            while(curr == req){
                if(j-i < min ){
                    start = i;
                    end = j;
                    min = j-i ;
                }
                map[s.charAt(i)]++;
                if(map[s.charAt(i)]>0){
                    curr--;
                }
                i++;
            }
        }
        if(min == Integer.MAX_VALUE) return "";
        return s.substring(start,end);
    }
}