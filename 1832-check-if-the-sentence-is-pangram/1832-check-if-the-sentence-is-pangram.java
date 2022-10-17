class Solution {
    public boolean checkIfPangram(String sentence) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i<sentence.length(); i++){
            map.put(sentence.charAt(i),map.getOrDefault(sentence.charAt(i),0)+1);
        }
        if(map.size()==26) return true;
        return false;
    }
}