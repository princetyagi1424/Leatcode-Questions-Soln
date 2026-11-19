import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int a : asteroids) {
            if (a > 0) {
                st.push(a);
            } else {
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(a)) {
                    st.pop();
                }
                if (!st.isEmpty() && st.peek() == Math.abs(a)) {
                    st.pop();
                } else if (st.isEmpty() || st.peek() < 0) {
                    st.push(a);
                }
            }
        }
        int[] ans = new int[st.size()];
        for (int i = 0; i < st.size(); i++) {
            ans[i] = st.get(i);
        }
        return ans;
    }
}
