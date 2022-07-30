class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> list =new ArrayList<>();
        int[] maxFreq2 = new int[26];
        
        for(int i=0; i<words2.length; i++){
            int[] inFreq = getFrequency(words2[i]);
            
            for(int j=0; j<26; j++){
                maxFreq2[j] = Math.max(maxFreq2[j],inFreq[j]);
            }
        }
        
        for(int i=0; i<words1.length; i++){
            
            int[] aFreq = getFrequency(words1[i]);
            
            boolean isSub = true;
            for(int j=0; j<26; j++){
                if((aFreq[j])<maxFreq2[j]){
                    isSub = false;
                    break;
                }
            }
            if(isSub){
                list.add(words1[i]);
            }
        }
        return list;
    }
    public int[] getFrequency(String word){
        int[] freq = new int[26];
        for(int i=0; i<word.length(); i++){
            freq[word.charAt(i)-'a']++;
        }
        return freq;
    }
    
}