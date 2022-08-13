class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if(s==null || s.length()==0 || words==null || words.length ==0){
            return new ArrayList<>();
        }
        List<Integer> list= new ArrayList<>();
        int totalWords = words.length;
        int eachWord = words[0].length();
        HashMap<String,Integer> map = new HashMap<>();
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        for(int i=0; i<=s.length()-eachWord*totalWords; i++){
            HashMap<String,Integer> seen = new HashMap<>();
            for(int j=0; j<totalWords; j++){
                int wordIdx = i+j*eachWord;
                String word = s.substring(wordIdx,wordIdx+eachWord);
                if(!map.containsKey(word)){
                    break;
                }
                seen.put(word,seen.getOrDefault(word,0)+1);
                if(seen.get(word)>map.getOrDefault(word,0)){
                    break;
                }
                if(j+1 ==  totalWords){
                    list.add(i);
                }
            }
        }
        return list;
    }
}