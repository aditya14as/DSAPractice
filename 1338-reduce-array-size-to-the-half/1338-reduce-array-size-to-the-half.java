class Solution {

    public int minSetSize(int[] arr) {
        System.out.println(arr.length);
        //Creating HashMap and Iterate through the arr and put all the numbers as 'key' and its occurances as 'value'
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        //Creating priority queue that adds Pair in decreasing order of their value
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        //Iterating throught the map and adding all its key value pair and new Pair and putting it inside the priority queue
        for (Map.Entry<Integer, Integer> set : map.entrySet()) {
            pq.add(new Pair(set.getKey(),set.getValue()));
        }
        //For minimum no of set the the we should remove the key that has more value in it
        int req = 0;
        int count = 0;
        int t=0;
        for(int i=0; i<pq.size(); i++){
            Pair p = pq.remove();
            // System.out.println(p.key+"@"+p.value);
            req = req+p.value; //Adding all the value of poped pair in req
            count++;
            //When req becomes half of arr.length then we break out of the loop as we get minimum count at this time
            if(req>=arr.length/2){
                break;
            }
        }
        // System.out.println(req);
        return count;
    }
}

//Creatin a Pair for key and value
class Pair implements Comparable<Pair> {
    int key;
    int value;
    Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
    
    //This part will make Priority queue prioritize Pair on the basis of value in decreasing order
    public int compareTo(Pair o) {
        return o.value - this.value;
    }
}
