class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        for(int i=0; i<words.length; i++){
            if(checkPattern(words[i],pattern)){
                list.add(words[i]);
            }
        }
        return list;
    }
    // public boolean checkPattern(String word,String pattern){
    //     for(int i=0; i<word.length();i++){
    //         if(word.indexOf(word.charAt(i)) != pattern.indexOf(pattern.charAt(i))){
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    
    public boolean checkPattern(String word, String pattern){
        HashMap<Character,Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for(int i=0; i<word.length(); i++){
            char wch = word.charAt(i);
            char pch = pattern.charAt(i);
            if(map.containsKey(pch)){
                if(map.get(pch)!=wch){
                    return false;
                }
            }else{
                if(set.contains(wch)){
                    return false;
                }
                map.put(pch,wch);
                set.add(wch);
            }
        }
        return true;
    }
}