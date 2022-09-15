class Solution {

    public int[] findOriginalArray(int[] changed) {
        Arrays.sort(changed);
        if (changed.length % 2 == 1 || changed.length == 0) {
            return new int[] {};
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < changed.length; i++) {
            map.put(changed[i], map.getOrDefault(changed[i], 0) + 1);
        }
        int[] ans = new int[changed.length / 2];
        int idx = 0;
        for (int i = 0; i < changed.length; i++) {
            if (map.containsKey(changed[i] * 2) && map.containsKey(changed[i]) && idx < changed.length / 2) {
                ans[idx] = changed[i];
                if (map.containsKey(changed[i] * 2)) {
                    if (map.get(changed[i] * 2) == 1) {
                        map.remove(changed[i] * 2);
                    } else {
                        map.put(changed[i] * 2, map.get(changed[i] * 2) - 1);
                    }
                }
                if (map.containsKey(changed[i])) {
                    if (map.get(changed[i]) == 1) {
                        map.remove(changed[i]);
                    } else {
                        map.put(changed[i], map.get(changed[i]) - 1);
                    }
                }
                idx++;
            }
        }
        if (map.size() == 0) {
            return ans;
        }
        return new int[] {};
    }
}
