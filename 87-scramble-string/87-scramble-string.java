class Solution {
    public Map<String, Boolean> mp = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        if(s1.equals(s2) == true){
            return true;
        }
        
        if(s1.isEmpty() == true){
            return true;
        }
        
        return helper(s1,s2);
    }
    public boolean helper(String a, String b){
        if(a.length() != b.length()){
            return false;
        }
        if(a.equals(b)==true){
            return true;
        }
        
        if(a.length()<=1){
            return false;
        }
        
        int n = a.length();
        boolean flag = false;
        String key = a + "_" + b;
        if(mp.containsKey(key)){
            return mp.get(key);
        }
        
        for(int i=1; i<n; i++){
            boolean unswap = helper(a.substring(0,i), b.substring(0,i) ) && helper(a.substring(i), b.substring(i));
            boolean swap = helper(a.substring(0,i),b.substring(n-i)) && helper(a.substring(i),b.substring(0,n-i));
            if(swap || unswap){
                flag = true;
                break;
            }  
        }
        mp.put(key,flag);
        return flag;
    }
    
}