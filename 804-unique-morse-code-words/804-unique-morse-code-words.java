class Solution {
    public int uniqueMorseRepresentations(String[] words) {
         String[] arr = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<words.length; i++){
            set.add(morse(words[i],arr));
        }
        return set.size();
    }
    public String morse(String word,String[] arr){
        String m = "";
        for(int i=0; i<word.length(); i++){
            m= m+arr[word.charAt(i)-97];
        }
        return m;
    }
}