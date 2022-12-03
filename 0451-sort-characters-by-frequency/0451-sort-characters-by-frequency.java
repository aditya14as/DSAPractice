class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(Map.Entry<Character,Integer> i : map.entrySet()){
            pq.add(new Pair(i.getKey(),i.getValue()));
        }
        String ans = "";
        for(int i = 0; i<map.size(); i++){
            char ch = pq.poll().ch;
            for(int j = 0; j<map.get(ch); j++){
                ans = ans + ch;
            }
        }
        return ans;
    }
}
class Pair implements Comparable<Pair>{
    char ch;
    int f;
    Pair(char ch, int f){
        this.ch = ch;
        this.f = f;
    }
    public int compareTo(Pair o){
        return o.f - this.f;
    }
}