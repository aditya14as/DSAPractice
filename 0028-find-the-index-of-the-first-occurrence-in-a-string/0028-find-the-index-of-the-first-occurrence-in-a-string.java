class Solution {
    public int strStr(String haystack, String needle) {
        int i=0; 
        int j=0;
        while(i<=haystack.length()){
            if(j==needle.length()){
                return i-needle.length();
            }
            if(i==haystack.length()){
                return -1;
            }
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }else{
                if(j==0){
                    i++;
                }else{
                    i=i-j+1;
                    j=0;
                }
            }
        }
        return -1;
    }
}