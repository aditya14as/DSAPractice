class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length()){
            return false;
        }
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        for(int i=0; i<word1.length(); i++){
           map1.put(word1.charAt(i), map1.getOrDefault(word1.charAt(i),0)+1);
        }
        for(int i=0; i<word2.length(); i++){
           map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i),0)+1);
        }
        if(map1.size()!=map2.size()) return false;
        List<Integer> list1 = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            list1.add(entry.getValue());
        }
        Collections.sort(list1);
        List<Integer> list2 = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map2.entrySet()) {
            if(map1.get(entry.getKey())==null) return false;
            list2.add(entry.getValue());
        }
        Collections.sort(list2);
        if(list1.equals(list2)) return true;
        return false;
    }
}