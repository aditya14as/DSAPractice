class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums1.length; i++){
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
        }
        for(int i=0; i<nums2.length; i++){
            if(map.containsKey(nums2[i])){
                list.add(nums2[i]);
                if(map.get(nums2[i])==1){
                    map.remove(nums2[i]);
                }else{
                    map.put(nums2[i],map.get(nums2[i])-1);
                }
            }
        }
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) array[i] = list.get(i);
        return array;
    }
}