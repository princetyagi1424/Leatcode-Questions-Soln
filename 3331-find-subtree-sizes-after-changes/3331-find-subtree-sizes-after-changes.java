
import java.util.*;

class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        List<Integer>[] tree = new ArrayList[n];

        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) tree[parent[i]].add(i);

        int[] newParent = new int[n];
        int[] last = new int[26];
        int[] prev = new int[n];
        Arrays.fill(last, -1);
        Arrays.fill(newParent, -1);

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, 0});

        while (!stack.isEmpty()) {
            int[] curr = stack.pop();
            int node = curr[0];
            int state = curr[1];
            int c = s.charAt(node) - 'a';

            if (state == 0) {
                prev[node] = last[c];
                if (node != 0) {
                    newParent[node] = last[c] != -1 ? last[c] : parent[node];
                }

                last[c] = node;
                stack.push(new int[]{node, 1});

                for (int child : tree[node]) {
                    stack.push(new int[]{child, 0});
                }
            } else {
                last[c] = prev[node];
            }
        }

        List<Integer>[] newTree = new ArrayList[n];
        for (int i = 0; i < n; i++) newTree[i] = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            newTree[newParent[i]].add(i);
        }

        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        Stack<Integer> st = new Stack<>();
        List<Integer> order = new ArrayList<>();
        st.push(0);

        while (!st.isEmpty()) {
            int node = st.pop();
            order.add(node);

            for (int child : newTree[node]) {
                st.push(child);
            }
        }

        for (int i = order.size() - 1; i > 0; i--) {
            int node = order.get(i);
            ans[newParent[node]] += ans[node];
        }

        return ans;
    }
}
