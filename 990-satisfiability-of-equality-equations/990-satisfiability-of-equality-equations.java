class Solution {

    public boolean equationsPossible(String[] equations) {
        int[] rank = new int[26];
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        for (int i = 0; i < equations.length; i++) {
            String s = equations[i];
            if (s.charAt(1) == '=') {
                union(rank, parent, s.charAt(0) - 'a', s.charAt(3) - 'a');
            }
        }
        for (int i = 0; i < equations.length; i++) {
            String s = equations[i];
            if (s.charAt(1) == '!') {
                if (find(s.charAt(0) - 'a', parent) == find(s.charAt(3) - 'a', parent)) {
                    return false;
                }
            }
        }
        return true;
    }

    public int find(int x, int[] parent) {
        if (parent[x] == x) {
            return x;
        }
        int p = find(parent[x], parent);
        parent[x] = p;
        return p;
    }

    public void union(int[] rank, int[] parent, int u, int v) {
        u = find(u, parent);
        v = find(v, parent);
        if (v != u) {
            if (rank[u] > rank[v]) {
                parent[v] = u;
            } else if (rank[v] > rank[u]) {
                parent[u] = v;
            } else {
                parent[v] = u;
                rank[v]++;
            }
        }
    }
}
