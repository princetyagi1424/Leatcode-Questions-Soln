import java.util.*;

class Solution {
    private List<Integer>[] graph;
    private int[][] up;
    private int[] tin, tout, depth;
    private int[] bit;
    private int[] mask;
    private char[] chars;
    private int timer, LOG, n;

    public List<Boolean> palindromePath(
            int n, int[][] edges, String s, String[] queries) {

        this.n = n;
        LOG = 32 - Integer.numberOfLeadingZeros(n);

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        up = new int[LOG][n];
        tin = new int[n];
        tout = new int[n];
        depth = new int[n];
        bit = new int[n + 2];
        mask = new int[n];
        chars = s.toCharArray();

        timer = 0;
        dfs(0, 0);

        for (int i = 0; i < n; i++) {
            mask[i] = 1 << (chars[i] - 'a');
            updateRange(tin[i], tout[i], mask[i]);
        }

        List<Boolean> ans = new ArrayList<>();

        for (String query : queries) {
            String[] parts = query.split(" ");

            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);

                int newMask = 1 << (c - 'a');
                int diff = mask[u] ^ newMask;

                if (diff != 0) {
                    updateRange(tin[u], tout[u], diff);
                    mask[u] = newMask;
                    chars[u] = c;
                }

            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int ancestor = lca(u, v);

                int pathMask = prefix(tin[u])
                             ^ prefix(tin[v])
                             ^ mask[ancestor];

                // At most one character can have odd frequency.
                ans.add((pathMask & (pathMask - 1)) == 0);
            }
        }

        return ans;
    }

    private void dfs(int u, int parent) {
        tin[u] = ++timer;
        up[0][u] = parent;

        for (int k = 1; k < LOG; k++) {
            up[k][u] = up[k - 1][up[k - 1][u]];
        }

        for (int v : graph[u]) {
            if (v == parent) {
                continue;
            }

            depth[v] = depth[u] + 1;
            dfs(v, u);
        }

        tout[u] = timer;
    }

    private int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int k = LOG - 1; k >= 0; k--) {
            if ((diff & (1 << k)) != 0) {
                u = up[k][u];
            }
        }

        if (u == v) {
            return u;
        }

        for (int k = LOG - 1; k >= 0; k--) {
            if (up[k][u] != up[k][v]) {
                u = up[k][u];
                v = up[k][v];
            }
        }

        return up[0][u];
    }

    // Apply XOR to an Euler-tour range [l, r].
    private void updateRange(int l, int r, int value) {
        add(l, value);
        add(r + 1, value);
    }

    private void add(int index, int value) {
        for (int i = index; i <= n + 1; i += i & -i) {
            bit[i] ^= value;
        }
    }

    private int prefix(int index) {
        int result = 0;

        for (int i = index; i > 0; i -= i & -i) {
            result ^= bit[i];
        }

        return result;
    }
}